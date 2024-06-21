package data_access.factories.interfaces;

import data_access.interfaces.UserReadDataAccessInterface;
import entity.user.UserFactory;

import java.sql.SQLException;

public interface DatabaseUserReadDataAccessObjectFactoryInterface {
    UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException;
}
