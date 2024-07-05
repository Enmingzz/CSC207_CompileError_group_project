package data_access.factories.interfaces.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserCreateDataAccessObjectFactoryInterface {

    UserCreateDataAccessInterface create() throws SQLException;
}
