package data_access;

import entity.CommonUserFactory;
import entity.UserFactory;

import java.sql.SQLException;

public interface DatabaseUserReadDataAccessObjectFactoryInterface {
    UserReadDataAccessInterface create(UserFactory commonUserFactory) throws SQLException;
}
