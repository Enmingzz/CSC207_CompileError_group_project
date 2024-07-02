package data_access.factories.interfaces.user;

import data_access.interfaces.user.UserUpdateNameDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserUpdateNameDataAccessObjectFactoryInterface {

    UserUpdateNameDataAccessInterface create() throws SQLException;
}
