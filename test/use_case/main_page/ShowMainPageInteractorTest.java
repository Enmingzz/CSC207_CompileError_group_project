package use_case.main_page;

import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;
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
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShowMainPageInteractorTest {

    private User user;
    private ArrayList<Product> databaseProducts;

    @BeforeEach
    void setUp() throws IOException {

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        // product1 initialized is a normal product on sale with 2 tags

        Image image = ImageIO.read(new File("src.pic.testpic1.png"));

        String description = "This is a description";

        String title = "This is a normal product";

        float price = 1;

        Integer rating = 0;

        int state = 0;

        String eTransferEmail = "example@email.com";

        String sellerStudentNumber = "1234567890";

        String address = "BA 3175";

        ArrayList<String> listTags = new ArrayList<>();

        listTags.add("Tag 1");

        listTags.add("Tag 2");

        String productID = "id_1";

        LocalDateTime buyerTime = null;

        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();

        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);

        Product product1 = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product1);

        // product2 is a product on sale with 1 tag and a non-zero state

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

        Schedule schedule2 = scheduleFactory.createSchedule(buyerTime, sellerTime);

        Product product2 = productFactory.createProduct(
                image2, description2, title2, price2, rating2, state2, eTransferEmail2, sellerStudentNumber2, address2,
                listTags2, productID2, schedule2
        );

        databaseProducts.add(product2);

        UserFactory userFactory = new CommonUserFactory();

        String name = "username";
        String password = "password";
        String email = "example@email.com";
        float userRating = 0;
        String studentNumber = "1234567890";

        user = userFactory.createUser(name, password, email, userRating, studentNumber);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void showMainPage() {

        ShowMainPageOutputBoundary mockPresenter = new ShowMainPageOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowMainPageOutputData response) {

            }
        };
    }
}