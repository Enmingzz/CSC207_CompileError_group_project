package data_access.in_memory.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.*;
import entity.product.Product;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * In-memory implementation of {@link QuestionReadDataAccessInterface} to read questions associated with products.
 */
public class InMemoryQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {

    private ArrayList<Question> questions;
    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory question data access object.
     */
    public InMemoryQuestionReadDataAccessObject() {
        this.questions = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory question data access object with predefined lists of questions and products.
     *
     * @param questions the list of questions to initialize with
     * @param products  the list of products to initialize with
     */
    public InMemoryQuestionReadDataAccessObject(ArrayList<Question> questions, ArrayList<Product> products) {
        this.questions = questions;
        this.products = products;
    }

    /**
     * Retrieves questions associated with a product ID.
     *
     * @param productID the ID of the product to retrieve questions for
     * @return a list of questions associated with the specified product ID
     * @throws SQLException if a database access error occurs
     */
    @Override
    public ArrayList<Question> getQuestion(String productID) throws SQLException {
        ArrayList<Question> returnedQuestions = new ArrayList<>();
        for (int i = 0; i < this.questions.size(); i++) {
            if (products.get(i).getProductID().equals(productID)){
                Question question = questions.get(i);

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
                    returnedQuestions.add(newQuestion);
                }
            }
        }

        return returnedQuestions;
    }
}
