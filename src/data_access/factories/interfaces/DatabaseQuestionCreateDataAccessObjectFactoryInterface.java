package data_access.factories.interfaces;

import data_access.interfaces.QuestionCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionCreateDataAccessObjectFactoryInterface {

    QuestionCreateDataAccessInterface create() throws SQLException;
}
