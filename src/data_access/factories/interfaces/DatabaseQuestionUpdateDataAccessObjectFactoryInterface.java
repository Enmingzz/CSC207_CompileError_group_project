package data_access.factories.interfaces;

import data_access.interfaces.QuestionUpdateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionUpdateDataAccessObjectFactoryInterface {

    QuestionUpdateDataAccessInterface create() throws SQLException;
}
