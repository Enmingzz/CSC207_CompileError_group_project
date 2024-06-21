package data_access.factories.objects;

import data_access.interfaces.UserCreateDataAccessInterface;
import data_access.factories.interfaces.DatabaseUserUpdatePictureDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseUserCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseUserUpdatePictureDataAccessObjectFactory implements DatabaseUserUpdatePictureDataAccessObjectFactoryInterface {

    public UserCreateDataAccessInterface create() throws SQLException {
        return new DatabaseUserCreateDataAccessObject();
    }
}
