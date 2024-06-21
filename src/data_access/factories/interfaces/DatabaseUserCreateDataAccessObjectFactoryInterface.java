package data_access.factories.interfaces;

import data_access.interfaces.UserCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserCreateDataAccessObjectFactoryInterface {

    UserCreateDataAccessInterface create() throws SQLException;
}
