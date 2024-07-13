package use_case.view_product;

import data_access.in_memory.question.InMemoryQuestionReadDataAccessObject;
import data_access.interfaces.question.QuestionReadDataAccessInterface;
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
import javax.swing.text.View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ViewProductInteractorTest {
    private ViewProductInteractor viewProductInteractor;
    private Product product;
    private User user;


    @BeforeEach
    void setUp() throws IOException {
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

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        user = new CommonUser("ginger cat", "111", "ginger@mail.utoronto.ca",
                5, "1234567890");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException {
        QuestionReadDataAccessInterface questionRepository = new InMemoryQuestionReadDataAccessObject();

        ViewProductOutputBoundary presenter = new ViewProductOutputBoundary() {
            @Override
            public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) throws SQLException {
                assertEquals(product, viewProductOutputData.getProduct());
                assertEquals(questionRepository.getQuestion(product.getProductID()),viewProductOutputData.getList_of_question());
                assertEquals(user, viewProductOutputData.getUser());
                if(Objects.equals(user.getStudentNumber(), product.getSellerStudentNumber())){
                    assertEquals("seller", viewProductOutputData.getUser_type());
                } else if (Objects.equals(user.getStudentNumber(), "")) {
                    assertEquals("", viewProductOutputData.getUser_type());//TODO check the default unlogged in user type
                }else {
                    assertEquals("buyer", viewProductOutputData.getUser_type());
                }
            }
        };
        ViewProductInputData inputData = new ViewProductInputData(product, user);
        ViewProductInputBoundary interactor = new ViewProductInteractor(presenter, questionRepository);
        interactor.execute(inputData);
    }
}