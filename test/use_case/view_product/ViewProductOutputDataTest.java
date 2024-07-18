package use_case.view_product;

import entity.comment.Question;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUser;
import entity.user.User;
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

/**
 * Unit test class for the ViewProductOutputData class.
 */

class ViewProductOutputDataTest {
    private ViewProductOutputData viewProductOutputData;
    private Product product;
    private ArrayList<Question> questions;
    private String user_type;
    private User user;

    /**
     * Sets up the test environment before each test.
     *
     * @throws IOException if an error occurs while reading the image file
     */

    @BeforeEach
    void setUp() throws IOException {
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = " ";
        float price = 1;
        String title = "ginger cat";
        int state = 1;
        Integer rating = 5;
        String eTransferEmail = "";
        String sellerStudentNumber = "";
        String address = "";
        LocalDateTime time = null;
        ArrayList<LocalDateTime> arrayList = new ArrayList<>();
        CommonScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        String productID = "";

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        questions = new ArrayList<>();

        user = new CommonUser("ginger cat", "111", "ginger@mail.utoronto.ca",
                5, "1234567890");

        user_type = "seller";


        viewProductOutputData = new ViewProductOutputData(product, questions, user_type, user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProduct() {
        assertEquals(product, viewProductOutputData.getProduct());    }

    @Test
    void getList_of_question() {
        assertEquals(questions, viewProductOutputData.getList_of_question());
    }

    @Test
    void getUser_type() {
        assertEquals(user_type, viewProductOutputData.getUser_type());
    }

    @Test
    void getUser() {
        assertEquals(user, viewProductOutputData.getUser());
    }
}