package data_access.factories.objects.user;

import data_access.factories.interfaces.user.DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import data_access.objects.user.DatabaseUserUpdatePasswordDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserUpdatePasswordDataAccessObjectFactory implements DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface {

    public UserUpdatePasswordDataAccessInterface create() throws SQLException {
        return new DatabaseUserUpdatePasswordDataAccessObject();
    }
}
