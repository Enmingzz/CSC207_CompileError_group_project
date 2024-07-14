package use_case.schedule;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateBuyerScheduleDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateStateDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.CommonProduct;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuyerSelectScheduleInteractorTest {
    private User buyer;
    private Product product;
    private String productID;
    private LocalDateTime selectedTime;
    private ArrayList<Product> products;


    @BeforeEach
    void setUp() throws IOException {

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 2;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        sellerTime.add(LocalDateTime.parse("2024-07-13T12:00:00"));
        sellerTime.add(LocalDateTime.parse("2024-07-13T13:00:00"));
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        productID = "id_1";

        product = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        buyer = userFactory.createUser(name, password, email, userRating, studentNumber);

        products = new ArrayList<>();
        products.add(product);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void prepareSuccessfulView() throws SQLException, IOException {
        selectedTime = LocalDateTime.parse("2024-07-13T12:00:00");
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(products);
        BuyerSelectScheduleOutputBoundary buyerSelectSchedulePresenter = new BuyerSelectScheduleOutputBoundary() {
            @Override
            public void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData) throws SQLException, IOException {
                assertEquals(selectedTime, outputData.getProduct().getSchedule().getBuyerTime());
                assertEquals(3, outputData.getProduct().getState());
                Product dataBaseProduct = inMemoryProductReadByIdDataAccessObject.getProductById(productID);
                assertEquals(dataBaseProduct.getSchedule().getBuyerTime(), outputData.getProduct().getSchedule().getBuyerTime());
                assertEquals(dataBaseProduct.getState(), outputData.getProduct().getState());
            }

            @Override
            public void prepareFailedView(String error) {
                assert(false);
            }

        };
        ProductUpdateBuyerScheduleDataAccessInterface inMemoryProductUpdateBuyerScheduleDataAccessObject =
                new InMemoryProductUpdateBuyerScheduleDataAccessObject(products);
        ProductUpdateStateDataAccessInterface inMemoryProductUpdateStateDataAccessObject =
                new InMemoryProductUpdateStateDataAccessObject(products);
        BuyerSelectScheduleInteractor buyerSelectScheduleInteractor =
                new BuyerSelectScheduleInteractor(buyerSelectSchedulePresenter, inMemoryProductReadByIdDataAccessObject,
                        inMemoryProductUpdateBuyerScheduleDataAccessObject, inMemoryProductUpdateStateDataAccessObject);

        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(buyer, product, selectedTime);
        buyerSelectScheduleInteractor.execute(inputData);

    }

    void prepareFailedView() throws SQLException, IOException {
        selectedTime = null;
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(products);
        BuyerSelectScheduleOutputBoundary buyerSelectSchedulePresenter = new BuyerSelectScheduleOutputBoundary() {
            @Override
            public void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData) {
                assert(false);
            }

            @Override
            public void prepareFailedView(String error) {
                assertEquals("No time selected. Please select a time.", error);
            }
        };
        ProductUpdateBuyerScheduleDataAccessInterface inMemoryProductUpdateBuyerScheduleDataAccessObject =
                new InMemoryProductUpdateBuyerScheduleDataAccessObject(products);
        ProductUpdateStateDataAccessInterface inMemoryProductUpdateStateDataAccessObject =
                new InMemoryProductUpdateStateDataAccessObject(products);
        BuyerSelectScheduleInteractor buyerSelectScheduleInteractor =
                new BuyerSelectScheduleInteractor(buyerSelectSchedulePresenter, inMemoryProductReadByIdDataAccessObject,
                        inMemoryProductUpdateBuyerScheduleDataAccessObject, inMemoryProductUpdateStateDataAccessObject);

        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(buyer, product, selectedTime);
        buyerSelectScheduleInteractor.execute(inputData);
    }
}