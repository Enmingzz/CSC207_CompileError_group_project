package data_access.factories.interfaces.question;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseQuestionCreateDataAccessObjectFactoryInterface provides an abstraction for creating instances of QuestionCreateDataAccessInterface.
 */
public interface DatabaseQuestionCreateDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of QuestionCreateDataAccessInterface.
     *
     * @return an instance of QuestionCreateDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    QuestionCreateDataAccessInterface create() throws SQLException;
}
