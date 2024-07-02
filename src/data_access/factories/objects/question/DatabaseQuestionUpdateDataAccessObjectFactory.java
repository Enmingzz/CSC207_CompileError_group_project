package data_access.factories.objects.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import data_access.factories.interfaces.question.DatabaseQuestionUpdateDataAccessObjectFactoryInterface;
import data_access.objects.question.DatabaseQuestionUpdateDataAccessObject;

import java.sql.SQLException;

public class DatabaseQuestionUpdateDataAccessObjectFactory implements DatabaseQuestionUpdateDataAccessObjectFactoryInterface {
    @Override
    public QuestionUpdateDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionUpdateDataAccessObject();
    }
}
