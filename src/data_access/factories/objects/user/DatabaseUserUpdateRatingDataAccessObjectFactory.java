package data_access.factories.objects.user;

import data_access.factories.interfaces.user.DatabaseUserUpdateRatingDataAccessObjectFactoryInterface;
import data_access.interfaces.user.UserUpdateRatingDataAccessInterface;
import data_access.objects.user.DatabaseUserUpdateRatingDataAccess;

import java.sql.SQLException;

public class DatabaseUserUpdateRatingDataAccessObjectFactory implements DatabaseUserUpdateRatingDataAccessObjectFactoryInterface {
    @Override
    public UserUpdateRatingDataAccessInterface create() throws SQLException {
        return new DatabaseUserUpdateRatingDataAccess();
    }
}
