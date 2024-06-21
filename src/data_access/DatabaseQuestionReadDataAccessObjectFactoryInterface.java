package data_access;

import java.sql.SQLException;

public interface DatabaseQuestionReadDataAccessObjectFactoryInterface {

    QuestionReadDataAccessInterface create() throws SQLException;
}
