package data_access.factories.interfaces.question;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionCreateDataAccessObjectFactoryInterface {

    QuestionCreateDataAccessInterface create() throws SQLException;
}
