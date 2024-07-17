package use_case.profile.modify_profile;

import entity.user.User;

import java.sql.SQLException;

/**
 * Interface for modifying the user's name.
 * Provides a method to execute the action of updating the user's name.
 */
public interface ModifyProfileNameInterface {

    /**
     * Executes the action of updating the user's name.
     *
     * @param user the user whose name is to be updated
     * @return true if the name was successfully updated, false if the name remained unchanged
     * @throws SQLException if a database access error occurs
     */
    boolean execute(User user) throws SQLException;
}
