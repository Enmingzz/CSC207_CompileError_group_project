package data_access.factories.objects;

import data_access.interfaces.QuestionUpdateDataAccessInterface;
import data_access.factories.interfaces.DatabaseQuestionUpdateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseQuestionUpdateDataAccessObject;

import java.sql.SQLException;

public class DatabaseQuestionUpdateDataAccessObjectFactory implements DatabaseQuestionUpdateDataAccessObjectFactoryInterface {
    @Override
    public QuestionUpdateDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionUpdateDataAccessObject();
    }
}
