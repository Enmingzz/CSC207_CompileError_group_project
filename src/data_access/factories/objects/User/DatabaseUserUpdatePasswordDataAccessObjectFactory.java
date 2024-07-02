package data_access.factories.objects.User;

import data_access.factories.interfaces.User.DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface;
import data_access.interfaces.User.UserUpdateNameDataAccessInterface;
import data_access.interfaces.User.UserUpdatePasswordDataAccessInterface;
import data_access.objects.User.DatabaseUserUpdatePasswordDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserUpdatePasswordDataAccessObjectFactory implements DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface {

    public UserUpdatePasswordDataAccessInterface create() throws SQLException {
        return new DatabaseUserUpdatePasswordDataAccessObject();
    }
}
