package data_access.factories.objects.user;

import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.objects.user.DatabaseUserReadDataAccessObject;
import entity.user.UserFactory;

import java.sql.SQLException;

public class DatabaseUserReadDataAccessObjectFactory implements DatabaseUserReadDataAccessObjectFactoryInterface {
    @Override
    public UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException {
        return new DatabaseUserReadDataAccessObject(commonUserFactory);
    }
}
