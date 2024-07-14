package use_case.view_product;

import data_access.in_memory.question.InMemoryQuestionUpdateDataAccessObject;
import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestion;
import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.view_product.ReplyQuestionPresenter;
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

class ReplyQuestionInteractorTest {

//    private ReplyQuestionInteractor replyQuestionInteractor;
    Question question;
    Product product;
    User seller;
    String answerDescription;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    @BeforeEach
    void setUp() throws IOException {
        question  = new CommonQuestion("", "", null, "123");

        Image image = ImageIO.read(new File("D:/24 summer/csc207/CSC207_CompileError_group_project/src/pic/testpic1.png"));
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


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException {
        QuestionUpdateDataAccessInterface questionUpdateData = new InMemoryQuestionUpdateDataAccessObject();

        ReplyQuestionOutputBoundary successPresenter = new ReplyQuestionOutputBoundary() {
            @Override
            public void prepareSuccessView(ReplyQuestionOutputData replyQuestionOutputData) {
                assertEquals(question,replyQuestionOutputData.getQuestion());
                assertEquals("question successfully published", replyQuestionOutputData.getOutputStr());
            }
        };
        ReplyQuestionInputData inputData = new ReplyQuestionInputData(product, seller, question, answerDescription);
        ReplyQuestionInputBoundary interactor = new ReplyQuestionInteractor(questionUpdateData, successPresenter,
                new CommonAnswerFactory(), new CommonQuestionFactory());

        interactor.execute(inputData);
    }
}