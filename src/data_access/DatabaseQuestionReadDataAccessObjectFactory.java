package data_access;

import java.sql.SQLException;

public class DatabaseQuestionReadDataAccessObjectFactory implements DatabaseQuestionReadDataAccessObjectFactoryInterface{
    @Override
    public QuestionReadDataAccessInterface create() throws SQLException {
        return new DatabaseQuestionReadDataAccessObject();
    }
}
