package data_access.interfaces.question;

import entity.comment.Question;
import entity.product.Product;

import java.sql.SQLException;

/**
 * QuestionCreateDataAccessInterface provides an abstraction for creating and saving a question related to a product in the database.
 */
public interface QuestionCreateDataAccessInterface {

    /**
     * Saves the specified question related to the specified product in the database.
     *
     * @param question the question to be saved
     * @param product  the product related to the question
     * @throws SQLException if a database access error occurs
     */
    void saveQuestion(Question question, Product product) throws SQLException;
}
