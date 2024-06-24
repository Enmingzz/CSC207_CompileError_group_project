package data_access.factories.interfaces.Question;

import data_access.interfaces.Question.QuestionCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseQuestionCreateDataAccessObjectFactoryInterface {

    QuestionCreateDataAccessInterface create() throws SQLException;
}
