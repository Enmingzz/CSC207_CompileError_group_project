package use_case.profile.modify_profile;

import entity.user.User;

import java.sql.SQLException;

/**
 * Interface for modifying the user's password.
 * Provides a method to execute the action of updating the user's password.
 */
public interface ModifyProfilePasswordInterface {

    /**
     * Executes the action of updating the user's password.
     *
     * @param user the user whose password is to be updated
     * @return true if the password was successfully updated, false if the password remained unchanged
     * @throws SQLException if a database access error occurs
     */
    boolean execute(User user) throws SQLException;
}
