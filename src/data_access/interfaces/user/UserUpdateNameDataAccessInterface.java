package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

/**
 * UserUpdateNameDataAccessInterface provides an abstraction for updating the name of a user in the database.
 */
public interface UserUpdateNameDataAccessInterface {

    /**
     * Updates the name of the specified user in the database.
     *
     * @param user the user whose name is to be updated
     * @param name the new name to be set for the user
     * @throws SQLException if a database access error occurs
     */
    void updateUserName(User user, String name) throws SQLException;
}
