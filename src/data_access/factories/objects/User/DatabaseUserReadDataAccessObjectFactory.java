package data_access.factories.objects.User;

import data_access.interfaces.User.UserReadDataAccessInterface;
import data_access.factories.interfaces.User.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.objects.User.DatabaseUserReadDataAccessObject;
import entity.user.UserFactory;

import java.sql.SQLException;

public class DatabaseUserReadDataAccessObjectFactory implements DatabaseUserReadDataAccessObjectFactoryInterface {
    @Override
    public UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException {
        return new DatabaseUserReadDataAccessObject(commonUserFactory);
    }
}
