package data_access.factories.objects;

import data_access.interfaces.UserCreateDataAccessInterface;
import data_access.factories.interfaces.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseUserCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserCreateDataAccessObjectFactory implements DatabaseUserCreateDataAccessObjectFactoryInterface {

    @Override
    public UserCreateDataAccessInterface create() throws SQLException {
        return new DatabaseUserCreateDataAccessObject();
    }
}
