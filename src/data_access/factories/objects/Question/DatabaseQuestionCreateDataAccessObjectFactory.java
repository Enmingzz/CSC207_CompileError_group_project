package data_access.factories.objects.Question;

import data_access.interfaces.Question.QuestionCreateDataAccessInterface;
import data_access.factories.interfaces.Question.DatabaseQuestionCreateDataAccessObjectFactoryInterface;
import data_access.objects.Question.DatabaseQuestionCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseQuestionCreateDataAccessObjectFactory implements DatabaseQuestionCreateDataAccessObjectFactoryInterface {
    @Override
    public QuestionCreateDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionCreateDataAccessObject();
    }
}
