package data_access.factories.objects;

import data_access.interfaces.QuestionCreateDataAccessInterface;
import data_access.factories.interfaces.DatabaseQuestionCreateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseQuestionCreateDataAccessObject;

public class DatabaseQuestionCreateDataAccessObjectFactory implements DatabaseQuestionCreateDataAccessObjectFactoryInterface {
    @Override
    public QuestionCreateDataAccessInterface create() {
        return new DatabaseQuestionCreateDataAccessObject();
    }
}
