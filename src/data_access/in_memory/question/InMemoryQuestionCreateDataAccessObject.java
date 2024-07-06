package data_access.in_memory.question;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;

import java.sql.SQLException;

public class InMemoryQuestionCreateDataAccessObject implements QuestionCreateDataAccessInterface {


    @Override
    public void saveQuestion(Question question, Product product) throws SQLException {

    }
}
