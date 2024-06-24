package data_access.factories.interfaces.Question;

import data_access.interfaces.Question.QuestionUpdateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionUpdateDataAccessObjectFactoryInterface {

    QuestionUpdateDataAccessInterface create() throws SQLException;
}
