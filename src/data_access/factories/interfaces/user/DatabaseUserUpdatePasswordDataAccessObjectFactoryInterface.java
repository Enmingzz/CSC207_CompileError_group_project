package data_access.factories.interfaces.user;

import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface {

    UserUpdatePasswordDataAccessInterface create() throws SQLException;
}
