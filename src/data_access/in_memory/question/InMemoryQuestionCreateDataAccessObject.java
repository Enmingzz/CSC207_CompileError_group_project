package data_access.in_memory.question;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import entity.comment.*;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * In-memory implementation of {@link QuestionCreateDataAccessInterface} to create and save questions.
 */
public class InMemoryQuestionCreateDataAccessObject implements QuestionCreateDataAccessInterface {

    private ArrayList<Question> questions;
    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory question data access object.
     */
    public InMemoryQuestionCreateDataAccessObject() {
        this.questions = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory question data access object with predefined lists of questions and products.
     *
     * @param questions the list of questions to initialize with
     * @param products  the list of products to initialize with
     */
    public InMemoryQuestionCreateDataAccessObject(ArrayList<Question> questions, ArrayList<Product> products) {
        this.questions = questions;
        this.products = products;
    }

    /**
     * Saves a question and associates it with a product.
     *
     * @param question the question to save
     * @param product  the product to associate with the question
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void saveQuestion(Question question, Product product) throws SQLException {
        QuestionFactory questionFactory = new CommonQuestionFactory();

        if (question.getAnswer() == null) {
            Answer copyAnswer = null;
            Question newQuestion = questionFactory.createQuestion(question.getDescription(),
                    question.getStudentNumber(),
                    copyAnswer, question.getQuestionID());
            questions.add(newQuestion);
        }
        else {
            AnswerFactory answerFactory = new CommonAnswerFactory();

            Answer copyAnswer = answerFactory.createAnswer(question.getAnswer().getDescription(),
                    question.getAnswer().getStudentNumber());
            Question newQuestion = questionFactory.createQuestion(question.getDescription(),
                    question.getStudentNumber(),
                    copyAnswer, question.getQuestionID());
            questions.add(newQuestion);
        }

        ProductFactory productFactory = new CommonProductFactory();
        ArrayList<String> copyListTags = new ArrayList<>();
        for (String tag: product.getListTags()) {
            copyListTags.add(tag);
        }

        Schedule schedule = product.getSchedule();
        ArrayList<LocalDateTime> sellerTimes = new ArrayList<>();
        for (LocalDateTime sellerTime: schedule.getSellerTime()){
            sellerTimes.add(sellerTime);
        }
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule copySchedule  = scheduleFactory.createSchedule(schedule.getBuyerTime(),
                sellerTimes);
        Product copyProduct = productFactory.createProduct(product.getImage(),
                product.getDescription(),
                product.getTitle(),
                product.getPrice(),
                product.getRating(),
                product.getState(),
                product.geteTransferEmail(),
                product.getSellerStudentNumber(),
                product.getAddress(),
                copyListTags,
                product.getProductID(),
                copySchedule);

        products.add(copyProduct);
    }
}
