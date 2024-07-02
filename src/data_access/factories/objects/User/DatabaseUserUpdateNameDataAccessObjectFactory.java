package data_access.factories.objects.User;

import data_access.factories.interfaces.User.DatabaseUserUpdateNameDataAccessObjectFactoryInterface;
import data_access.interfaces.User.UserUpdateNameDataAccessInterface;
import data_access.objects.User.DatabaseUserUpdateNameDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserUpdateNameDataAccessObjectFactory implements DatabaseUserUpdateNameDataAccessObjectFactoryInterface {

    public UserUpdateNameDataAccessInterface create() throws SQLException {
        return new DatabaseUserUpdateNameDataAccessObject();
    }
}
