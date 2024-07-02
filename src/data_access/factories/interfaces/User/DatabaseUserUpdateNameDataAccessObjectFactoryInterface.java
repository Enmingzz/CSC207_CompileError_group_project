package data_access.factories.interfaces.User;

import data_access.interfaces.User.UserUpdateNameDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserUpdateNameDataAccessObjectFactoryInterface {

    UserUpdateNameDataAccessInterface create() throws SQLException;
}
