package data_access.factories.objects.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.objects.user.DatabaseUserCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserCreateDataAccessObjectFactory implements DatabaseUserCreateDataAccessObjectFactoryInterface {

    @Override
    public UserCreateDataAccessInterface create() throws SQLException {
        return new DatabaseUserCreateDataAccessObject();
    }
}
