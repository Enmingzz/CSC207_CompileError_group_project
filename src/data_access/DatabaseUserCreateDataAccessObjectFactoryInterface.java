package data_access;

import java.sql.SQLException;

public interface DatabaseUserCreateDataAccessObjectFactoryInterface {

    UserCreateDataAccessInterface create() throws SQLException;
}
