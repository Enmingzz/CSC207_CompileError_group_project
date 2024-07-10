package data_access.in_memory.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.*;
import entity.product.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {

    private ArrayList<Question> questions;
    private ArrayList<Product> products;

    public InMemoryQuestionReadDataAccessObject() {
        this.questions = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public InMemoryQuestionReadDataAccessObject(ArrayList<Question> questions, ArrayList<Product> products) {
        this.questions = questions;
        this.products = products;
    }

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
                            copyAnswer);
                    questions.add(newQuestion);
                }
                else {
                    AnswerFactory answerFactory = new CommonAnswerFactory();

                    Answer copyAnswer = answerFactory.createAnswer(question.getAnswer().getDescription(),
                            question.getAnswer().getStudentNumber());
                    Question newQuestion = questionFactory.createQuestion(question.getDescription(),
                            question.getStudentNumber(),
                            copyAnswer);
                    returnedQuestions.add(newQuestion);
                }
            }
        }

        return returnedQuestions;
    }
}
