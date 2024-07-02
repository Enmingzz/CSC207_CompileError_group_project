package data_access.factories.interfaces.User;

import data_access.interfaces.User.UserUpdateNameDataAccessInterface;
import data_access.interfaces.User.UserUpdatePasswordDataAccessInterface;
import data_access.objects.User.DatabaseUserUpdatePasswordDataAccessObject;

import java.sql.SQLException;

public interface DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface {

    UserUpdatePasswordDataAccessInterface create() throws SQLException;
}
