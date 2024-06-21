package data_access.factories.objects;

import data_access.interfaces.QuestionCreateDataAccessInterface;
import data_access.factories.interfaces.DatabaseQuestionCreateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseQuestionCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseQuestionCreateDataAccessObjectFactory implements DatabaseQuestionCreateDataAccessObjectFactoryInterface {
    @Override
    public QuestionCreateDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionCreateDataAccessObject();
    }
}
