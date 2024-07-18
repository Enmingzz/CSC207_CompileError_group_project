package use_case.view_product;

import entity.comment.CommonQuestion;
import entity.comment.Question;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
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
 * Unit test class for the PublishQuestionInputData class.
 */

class PublishQuestionInputDataTest {

    private PublishQuestionInputData publishQuestionInputData;

    /**
     * Sets up the test environment before each test.
     *
     * @throws IOException if an error occurs while reading the image file
     */

    @BeforeEach
    void setUp() throws IOException {
        Question question  = new CommonQuestion("", "", null, "");

        Image image = ImageIO.read(new File("D:/24 summer/csc207/CSC207_CompileError_group_project/src/pic/testpic1.png"));
        String des = " ";
        float price = 1;
        String title = "ginger_cat";
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

        Product product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        publishQuestionInputData = new PublishQuestionInputData(question, product);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Tests the getQuestion method.
     */
    @Test
    void getQuestion() {
        Question question  = new CommonQuestion("", "", null, "");
        assertEquals(question, publishQuestionInputData.getQuestion());
    }

    /**
     * Tests the getProduct method.
     *
     * @throws IOException if an error occurs while reading the image file
     */

    @Test
    void getProduct() throws IOException {
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = " ";
        float price = 1;
        String title = "ginger_cat";
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

        Product product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        assertEquals(product, publishQuestionInputData.getProduct());
    }
}