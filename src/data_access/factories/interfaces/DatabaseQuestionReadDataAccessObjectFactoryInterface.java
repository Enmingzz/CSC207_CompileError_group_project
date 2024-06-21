package data_access.factories.interfaces;

import data_access.interfaces.QuestionReadDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionReadDataAccessObjectFactoryInterface {

    QuestionReadDataAccessInterface create() throws SQLException;
}
