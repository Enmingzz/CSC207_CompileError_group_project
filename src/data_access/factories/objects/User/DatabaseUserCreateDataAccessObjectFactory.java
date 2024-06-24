package data_access.factories.objects.User;

import data_access.interfaces.User.UserCreateDataAccessInterface;
import data_access.factories.interfaces.User.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.objects.User.DatabaseUserCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserCreateDataAccessObjectFactory implements DatabaseUserCreateDataAccessObjectFactoryInterface {

    @Override
    public UserCreateDataAccessInterface create() throws SQLException {
        return new DatabaseUserCreateDataAccessObject();
    }
}
