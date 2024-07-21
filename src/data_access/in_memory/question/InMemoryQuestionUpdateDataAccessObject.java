package data_access.in_memory.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
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
import java.util.Objects;

/**
 * In-memory implementation of {@link QuestionUpdateDataAccessInterface} to update questions.
 */
public class InMemoryQuestionUpdateDataAccessObject implements QuestionUpdateDataAccessInterface {

    private ArrayList<Question> questions;
    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory question data access object.
     */
    public InMemoryQuestionUpdateDataAccessObject() {
        this.questions = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory question data access object with predefined lists of questions and products.
     *
     * @param questions the list of questions to initialize with
     * @param products  the list of products to initialize with
     */
    public InMemoryQuestionUpdateDataAccessObject(ArrayList<Question> questions, ArrayList<Product> products) {
        this.questions = questions;
        this.products = products;
    }

    /**
     * Updates a question.
     *
     * @param question the question to update
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateQuestion(Question question) throws SQLException {


        Answer copyAnswer = new CommonAnswer(question.getAnswer().getDescription(),
                question.getAnswer().getStudentNumber());

        Question newQuestion = new CommonQuestion(question.getDescription(),
                question.getStudentNumber(), copyAnswer, question.getQuestionID());

        for (int i = 0; i < this.questions.size(); i++){
            if(Objects.equals(questions.get(i).getQuestionID(), question.getQuestionID())){
                questions.set(i, newQuestion);
            }
        }
    }
}
