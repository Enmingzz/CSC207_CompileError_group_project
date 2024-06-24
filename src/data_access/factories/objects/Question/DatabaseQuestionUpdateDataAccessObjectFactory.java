package data_access.factories.objects.Question;

import data_access.interfaces.Question.QuestionUpdateDataAccessInterface;
import data_access.factories.interfaces.Question.DatabaseQuestionUpdateDataAccessObjectFactoryInterface;
import data_access.objects.Question.DatabaseQuestionUpdateDataAccessObject;

import java.sql.SQLException;

public class DatabaseQuestionUpdateDataAccessObjectFactory implements DatabaseQuestionUpdateDataAccessObjectFactoryInterface {
    @Override
    public QuestionUpdateDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionUpdateDataAccessObject();
    }
}
