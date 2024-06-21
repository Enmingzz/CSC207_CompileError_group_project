package data_access;

public class DatabaseQuestionCreateDataAccessObjectFactory implements DatabaseQuestionCreateDataAccessObjectFactoryInterface{
    @Override
    public QuestionCreateDataAccessInterface create() {
        return new DatabaseQuestionCreateDataAccessObject();
    }
}
