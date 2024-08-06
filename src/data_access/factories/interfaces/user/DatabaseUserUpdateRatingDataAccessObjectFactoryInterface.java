package data_access.factories.interfaces.user;

import data_access.interfaces.user.UserUpdateRatingDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseUserUpdateRatingDataAccessObjectFactoryInterface {
    UserUpdateRatingDataAccessInterface create() throws SQLException;
}
