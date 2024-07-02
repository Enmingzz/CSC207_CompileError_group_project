package data_access.factories.objects.user;

import data_access.factories.interfaces.user.DatabaseUserUpdateNameDataAccessObjectFactoryInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.objects.user.DatabaseUserUpdateNameDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserUpdateNameDataAccessObjectFactory implements DatabaseUserUpdateNameDataAccessObjectFactoryInterface {

    public UserUpdateNameDataAccessInterface create() throws SQLException {
        return new DatabaseUserUpdateNameDataAccessObject();
    }
}
