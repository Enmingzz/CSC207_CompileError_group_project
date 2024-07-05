package data_access.factories.interfaces.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionUpdateDataAccessObjectFactoryInterface {

    QuestionUpdateDataAccessInterface create() throws SQLException;
}
