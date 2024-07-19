package data_access.factories.interfaces.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseQuestionUpdateDataAccessObjectFactoryInterface provides an abstraction for creating instances of QuestionUpdateDataAccessInterface.
 */
public interface DatabaseQuestionUpdateDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of QuestionUpdateDataAccessInterface.
     *
     * @return an instance of QuestionUpdateDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    QuestionUpdateDataAccessInterface create() throws SQLException;
}
