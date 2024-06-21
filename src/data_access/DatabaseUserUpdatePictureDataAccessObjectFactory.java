package data_access;

import java.sql.SQLException;

public class DatabaseUserUpdatePictureDataAccessObjectFactory implements DatabaseUserUpdatePictureDataAccessObjectFactoryInterface{

    public UserCreateDataAccessInterface create() throws SQLException {
        return new DatabaseUserCreateDataAccessObject();
    }
}
