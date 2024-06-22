package data_access.factories.interfaces;

import data_access.interfaces.QuestionReadDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.QuestionFactory;

import java.sql.SQLException;

public interface DatabaseQuestionReadDataAccessObjectFactoryInterface {

    QuestionReadDataAccessInterface create(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException;
}
