package data_access.factories.objects.question;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import data_access.factories.interfaces.question.DatabaseQuestionCreateDataAccessObjectFactoryInterface;
import data_access.objects.question.DatabaseQuestionCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseQuestionCreateDataAccessObjectFactory implements DatabaseQuestionCreateDataAccessObjectFactoryInterface {
    @Override
    public QuestionCreateDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionCreateDataAccessObject();
    }
}
