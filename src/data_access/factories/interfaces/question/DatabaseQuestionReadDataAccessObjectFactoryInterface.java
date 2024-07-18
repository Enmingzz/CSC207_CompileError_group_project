package data_access.factories.interfaces.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.QuestionFactory;

import java.sql.SQLException;

/**
 * DatabaseQuestionReadDataAccessObjectFactoryInterface provides an abstraction for creating instances of QuestionReadDataAccessInterface.
 */
public interface DatabaseQuestionReadDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of QuestionReadDataAccessInterface.
     *
     * @param questionFactory a factory for creating Question objects
     * @param answerFactory   a factory for creating Answer objects
     * @return an instance of QuestionReadDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    QuestionReadDataAccessInterface create(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException;
}
