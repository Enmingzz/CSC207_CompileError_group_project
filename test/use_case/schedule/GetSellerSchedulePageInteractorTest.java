package use_case.schedule;

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

class GetSellerSchedulePageInteractorTest {
    private User seller;
    private Product product;

    @BeforeEach
    void setUp() throws IOException {
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 1;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1234567890";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        seller = userFactory.createUser(name, password, email, userRating, studentNumber);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException, IOException {
        GetSellerSchedulePageOutputBoundary getSellerSchedulePagePresenter = new GetSellerSchedulePageOutputBoundary() {
            @Override
            public void prepareSuccessfulView(GetSellerSchedulePageOutputData getSellerSchedulePageOutputData) {
                assertEquals(product, getSellerSchedulePageOutputData.getProduct());
                assertEquals(seller, getSellerSchedulePageOutputData.getSeller());
            }
        };
        GetSellerSchedulePageInputData inputData = new GetSellerSchedulePageInputData(seller, product);
        GetSellerSchedulePageInteractor interactor = new GetSellerSchedulePageInteractor(getSellerSchedulePagePresenter);
        interactor.execute(inputData);
    }
}