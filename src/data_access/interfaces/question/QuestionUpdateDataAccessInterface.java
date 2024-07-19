package data_access.interfaces.question;

import entity.comment.Question;

import java.sql.SQLException;

/**
 * QuestionUpdateDataAccessInterface provides an abstraction for updating a question in the database.
 */
public interface QuestionUpdateDataAccessInterface {

    /**
     * Updates the specified question in the database.
     *
     * @param question the question to be updated
     * @throws SQLException if a database access error occurs
     */
    void updateQuestion(Question question) throws SQLException;
}
