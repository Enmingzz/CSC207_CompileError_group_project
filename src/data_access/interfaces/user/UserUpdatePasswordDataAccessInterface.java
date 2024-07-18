package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

/**
 * UserUpdatePasswordDataAccessInterface provides an abstraction for updating the password of a user in the database.
 */
public interface UserUpdatePasswordDataAccessInterface {

    /**
     * Updates the password of the specified user in the database.
     *
     * @param user     the user whose password is to be updated
     * @param password the new password to be set for the user
     * @throws SQLException if a database access error occurs
     */
    void updateUserPassword(User user, String password) throws SQLException;
}
