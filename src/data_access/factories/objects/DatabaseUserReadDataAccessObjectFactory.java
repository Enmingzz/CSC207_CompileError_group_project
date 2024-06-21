package data_access.factories.objects;

import data_access.interfaces.UserReadDataAccessInterface;
import data_access.factories.interfaces.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseUserReadDataAccessObject;
import entity.UserFactory;

import java.sql.SQLException;

public class DatabaseUserReadDataAccessObjectFactory implements DatabaseUserReadDataAccessObjectFactoryInterface {
    @Override
    public UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException {
        return new DatabaseUserReadDataAccessObject(commonUserFactory);
    }
}
