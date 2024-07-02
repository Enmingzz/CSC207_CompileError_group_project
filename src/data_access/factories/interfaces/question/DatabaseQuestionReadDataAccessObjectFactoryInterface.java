package data_access.factories.interfaces.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.QuestionFactory;

import java.sql.SQLException;

public interface DatabaseQuestionReadDataAccessObjectFactoryInterface {

    QuestionReadDataAccessInterface create(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException;
}
