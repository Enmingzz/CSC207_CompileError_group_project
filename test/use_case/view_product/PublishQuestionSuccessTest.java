package use_case.view_product;

import data_access.in_memory.question.InMemoryQuestionCreateDataAccessObject;
import data_access.interfaces.question.QuestionCreateDataAccessInterface;

import entity.comment.Question;
import entity.comment.QuestionFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class PublishQuestionSuccessTest {

    QuestionFactory questionFactory ;
    ScheduleFactory scheduleFactory;
    ProductFactory productFactory;

    void successTest() throws IOException, SQLException {

        QuestionCreateDataAccessInterface questionRepository = new InMemoryQuestionCreateDataAccessObject();// need a new method in DAO, it should be

        PublishQuestionOutputBoundary successPresenter = new PublishQuestionOutputBoundary() {
            @Override
            public void prepareSuccessView(PublishQuestionOutputData publishQuestionOutputData) {
                assertEquals("question successfully published", publishQuestionOutputData.getOutputStr());
                // assertTrue(questionRepository.existQuestion());
            }
        };

        Question question  = questionFactory.createQuestion("", "", null);

        Image image = ImageIO.read(new File("C:/Users/12760/OneDrive/桌面/good_pic.jpg"));
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

        Product product = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        PublishQuestionInputData inputData = new PublishQuestionInputData(question, product);
        PublishQuestionInputBoundary interactor = new PublishQuestionInteractor(product, questionRepository,
                questionFactory, successPresenter);

        interactor.execute(inputData);
    }
}