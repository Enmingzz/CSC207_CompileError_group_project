package data_access.factories.interfaces.user;

import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.UserFactory;

import java.sql.SQLException;

public interface DatabaseUserReadDataAccessObjectFactoryInterface {
    UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException;
}
