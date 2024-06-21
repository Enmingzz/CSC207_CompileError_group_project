package data_access;

public class DatabaseQuestionUpdateDataAccessObjectFactory implements DatabaseQuestionUpdateDataAccessObjectFactoryInterface{
    @Override
    public QuestionUpdateDataAccessInterface create() {
        return new DatabaseQuestionUpdateDataAccessObject();
    }
}
