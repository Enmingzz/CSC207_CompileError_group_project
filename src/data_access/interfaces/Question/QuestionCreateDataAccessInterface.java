package data_access.interfaces.Question;

import entity.comment.Question;
import entity.product.Product;

import java.sql.SQLException;

public interface QuestionCreateDataAccessInterface {
    void saveQuestion(Question question, Product product) throws SQLException;
}
