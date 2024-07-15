package use_case.search_product;

import data_access.in_memory.product.InMemoryProductReadByTagDataAccessObject;
import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
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

class SearchProductByTagInteractorTest {
    private User user;
    private String tag;
    private ArrayList<Product> products;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() throws IOException {
        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        tag = "Tag1";

        // product1 is a product that has the tag we want to search and is on sale.
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "abc";
        int state = 0;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag1");
        String productID = "id_1";

        product1 = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        products = new ArrayList<>();
        products.add(product1);

        // product2 is a product that does not have the tag we want to search and is on sale.

        Image image2 = ImageIO.read(new File("src.pic.testpic2.png"));
        String description2 = "This is a description";
        String title2 = "bcd";
        float price2 = 2;
        Integer rating2 = 0;
        int state2 = 0;
        String eTransferEmail2 = "example@email.com";
        String sellerStudentNumber2 = "1234567890";
        String address2 = "BA 3185";
        ArrayList<String> listTags2 = new ArrayList<>();
        listTags2.add("Tag2");
        String productID2 = "id_2";
        LocalDateTime buyerTime2 = null;
        ArrayList<LocalDateTime> sellerTime2 = new ArrayList<>();
        Schedule schedule2 = scheduleFactory.createSchedule(buyerTime2, sellerTime2);
        product2 = productFactory.createProduct(
                image2, description2, title2, price2, rating2, state2, eTransferEmail2, sellerStudentNumber2, address2,
                listTags2, productID2, schedule2
        );

        products.add(product2);

        // product3 is a product that has the tag we want to search but is not on sale.
        Image image3 = ImageIO.read(new File("src.pic.testpic2.png"));
        String description3 = "This is a description";
        String title3 = "abc";
        float price3 = 2;
        Integer rating3 = 0;
        int state3 = 1;
        String eTransferEmail3 = "example@email.com";
        String sellerStudentNumber3 = "1234567890";
        String address3 = "BA 3185";
        ArrayList<String> listTags3 = new ArrayList<>();
        listTags3.add("Tag1");
        String productID3 = "id_2";
        LocalDateTime buyerTime3 = null;
        ArrayList<LocalDateTime> sellerTime3 = new ArrayList<>();
        Schedule schedule3 = scheduleFactory.createSchedule(buyerTime3, sellerTime3);
        product3 = productFactory.createProduct(
                image3, description3, title3, price3, rating3, state3, eTransferEmail3, sellerStudentNumber3, address3,
                listTags3, productID3, schedule3
        );

        products.add(product3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException, IOException {
        SearchProductByTagOutputBoundary searchProductByTagPresenter = new SearchProductByTagOutputBoundary() {
            @Override
            public void prepareSuccessfulView(SearchProductByTagOutputData searchProductByTagOutputData) {
                User actualUser = searchProductByTagOutputData.getUser();
                assertEquals(user, actualUser);

                ArrayList<Product> actualProducts = searchProductByTagOutputData.getProducts();
                ArrayList<Product> expectedProducts = new ArrayList<>();
                expectedProducts.add(product1); // only product1 should be displayed.
                assertEquals(expectedProducts, actualProducts);
            }
        };
        ProductReadByTagDataAccessInterface inMemoryProductReadByTagDataAccessObject =
                new InMemoryProductReadByTagDataAccessObject(products);
        SearchProductByTagInputData inputData = new SearchProductByTagInputData(user, tag);
        SearchProductByTagInteractor interactor =
                new SearchProductByTagInteractor(inMemoryProductReadByTagDataAccessObject, searchProductByTagPresenter);
        interactor.execute(inputData);
    }
}