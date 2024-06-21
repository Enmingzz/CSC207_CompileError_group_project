package data_access;

import java.sql.SQLException;

public class DatabaseUserCreateDataAccessObjectFactory implements DatabaseUserCreateDataAccessObjectFactoryInterface{

    @Override
    public UserCreateDataAccessInterface create() throws SQLException {
        return new DatabaseUserCreateDataAccessObject();
    }
}
