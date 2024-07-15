package use_case.search_product;

import data_access.in_memory.product.InMemoryProductReadAllDataAccessObject;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
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

class GetSearchViewInteractorTest {
    private User user;
    private ArrayList<Product> products;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() throws IOException {
        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        // product1 is a product that is on sale, so its state is 0.
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 0;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product1 = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        products.add(product1);

        // product2 is a product that is not on sale, so its state is non-zero

        Image image2 = ImageIO.read(new File("src.pic.testpic2.png"));
        String description2 = "This is a description";
        String title2 = "This is a title ";
        float price2 = 2;
        Integer rating2 = 0;
        int state2 = 1;
        String eTransferEmail2 = "example@email.com";
        String sellerStudentNumber2 = "1234567890";
        String address2 = "BA 3185";
        ArrayList<String> listTags2 = new ArrayList<>();
        listTags2.add("Tag 1");
        String productID2 = "id_2";
        LocalDateTime buyerTime2 = null;
        ArrayList<LocalDateTime> sellerTime2 = new ArrayList<>();
        Schedule schedule2 = scheduleFactory.createSchedule(buyerTime2, sellerTime2);
        product2 = productFactory.createProduct(
                image2, description2, title2, price2, rating2, state2, eTransferEmail2, sellerStudentNumber2, address2,
                listTags2, productID2, schedule2
        );

        products.add(product2);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSearchView() throws SQLException, IOException {
        GetSearchViewOutputBoundary getSearchViewOutputBoundary = new GetSearchViewOutputBoundary() {
            @Override
            public void prepareSuccessView(GetSearchViewOutputData getSearchViewOutputData) {
                User ActualUser = getSearchViewOutputData.getUser();
                assertEquals(user, ActualUser);

                ArrayList<Product> actualProducts = getSearchViewOutputData.getAllProducts();
                ArrayList<Product> expectedProducts = new ArrayList<>();
                expectedProducts.add(product1);
                assertEquals(expectedProducts, actualProducts); // only product1 should be displayed.
            }
        };
        ProductReadAllDataAccessInterface inMemoryProductReadAllDataAccessObject =
                new InMemoryProductReadAllDataAccessObject(products);
        GetSearchViewInputData inputData = new GetSearchViewInputData(user);
        GetSearchViewInteractor interactor =
                new GetSearchViewInteractor(getSearchViewOutputBoundary, inMemoryProductReadAllDataAccessObject);
        interactor.getSearchView(inputData);
    }
}