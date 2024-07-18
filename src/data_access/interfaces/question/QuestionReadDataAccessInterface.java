package data_access.interfaces.question;

import entity.comment.Question;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * QuestionReadDataAccessInterface provides an abstraction for retrieving questions related to a product from the database.
 */
public interface QuestionReadDataAccessInterface {

    /**
     * Retrieves questions related to the specified product from the database.
     *
     * @param productID the ID of the product whose questions are to be retrieved
     * @return an ArrayList of questions related to the specified product
     * @throws SQLException if a database access error occurs
     */
    ArrayList<Question> getQuestion(String productID) throws SQLException;
}
