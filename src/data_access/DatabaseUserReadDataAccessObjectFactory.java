package data_access;

import entity.CommonUserFactory;
import entity.UserFactory;

import java.sql.SQLException;

public class DatabaseUserReadDataAccessObjectFactory implements DatabaseUserReadDataAccessObjectFactoryInterface{
    @Override
    public UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException {
        return new DatabaseUserReadDataAccessObject(commonUserFactory);
    }
}
