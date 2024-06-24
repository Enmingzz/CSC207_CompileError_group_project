package data_access.factories.interfaces.User;

import data_access.interfaces.User.UserCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserCreateDataAccessObjectFactoryInterface {

    UserCreateDataAccessInterface create() throws SQLException;
}
