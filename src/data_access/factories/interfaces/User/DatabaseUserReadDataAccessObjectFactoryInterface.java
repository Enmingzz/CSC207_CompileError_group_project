package data_access.factories.interfaces.User;

import data_access.interfaces.User.UserReadDataAccessInterface;
import entity.user.UserFactory;

import java.sql.SQLException;

public interface DatabaseUserReadDataAccessObjectFactoryInterface {
    UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException;
}
