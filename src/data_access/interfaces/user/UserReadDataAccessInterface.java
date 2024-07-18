package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

/**
 * UserReadDataAccessInterface provides an abstraction for retrieving a user from the database using their student number.
 */
public interface UserReadDataAccessInterface {

    /**
     * Retrieves the user with the specified student number from the database.
     *
     * @param studentNumber the student number of the user to be retrieved
     * @return the user with the specified student number
     * @throws SQLException if a database access error occurs
     */
    User getUser(String studentNumber) throws SQLException;
}
