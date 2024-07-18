package use_case.view_product;

import entity.comment.CommonQuestion;
import entity.comment.Question;
import entity.comment.QuestionFactory;
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

class ReplyQuestionInputDataTest {

    private ReplyQuestionInputData replyQuestionInputData;
    private Question question;
    private Product product;
    private User seller;
    private String answerDescription;


    @BeforeEach
    void setUp() throws IOException {
        question  = new CommonQuestion("", "", null, "123");

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

        seller = new CommonUser("ginger cat", "111", "ginger@mail.utoronto.ca",
                5, "1234567890");

        answerDescription = "ginger ginger";

        replyQuestionInputData = new ReplyQuestionInputData(product, seller, question, answerDescription);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProduct() throws IOException {
        assertEquals(product, replyQuestionInputData.getProduct());
    }

    @Test
    void getQuestion() {
//        question  = new CommonQuestion("", "", null);
        assertEquals(question, replyQuestionInputData.getQuestion());
    }

    @Test
    void getSeller() {
//        seller = new CommonUser("ginger cat", "111", "ginger@mail.utoronto.ca", 5, "1009834342");
        assertEquals(seller, replyQuestionInputData.getSeller());
    }

    @Test
    void getAnswerDescription() {
//        String answerDescription = "ginger ginger";
        assertEquals(answerDescription, replyQuestionInputData.getAnswerDescription());
    }

}