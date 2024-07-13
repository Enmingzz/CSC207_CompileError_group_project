package use_case.view_product;

import data_access.in_memory.question.InMemoryQuestionCreateDataAccessObject;
import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
import entity.comment.QuestionFactory;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PublishQuestionInteractorTest {

    private Question question;
    private Product product;
    private ScheduleFactory scheduleFactory = new CommonScheduleFactory();
    private QuestionFactory questionFactory = new CommonQuestionFactory();
    private ProductFactory productFactory = new CommonProductFactory();
    private ArrayList<Question> questions = new ArrayList<>();

    @BeforeEach
    void setUp() throws IOException {
        question  = questionFactory.createQuestion("", "", null, );

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
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        String productID = "";

        product = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException {

        QuestionCreateDataAccessInterface questionRepository = new InMemoryQuestionCreateDataAccessObject(questions);// need a new method in DAO, it should be


        PublishQuestionOutputBoundary successPresenter = new PublishQuestionOutputBoundary() {
            @Override
            public void prepareSuccessView(PublishQuestionOutputData publishQuestionOutputData) {
                assertEquals("question successfully published", publishQuestionOutputData.getOutputStr());
                //TODO Assert that the question is already stored in InMemoryDAO
                assertEquals(questionRepository.);
            }
        };

        PublishQuestionInputData inputData = new PublishQuestionInputData(question, product);
        PublishQuestionInputBoundary interactor = new PublishQuestionInteractor(product, questionRepository,
                new CommonQuestionFactory(), successPresenter);

        interactor.execute(inputData);
    }
}
