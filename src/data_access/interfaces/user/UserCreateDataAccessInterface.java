package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

/**
 * UserCreateDataAccessInterface provides an abstraction for creating and saving a user in the database.
 */
public interface UserCreateDataAccessInterface {

    /**
     * Saves the specified user in the database.
     *
     * @param user the user to be saved
     * @throws SQLException if a database access error occurs
     */
    void saveUser(User user) throws SQLException;
}
