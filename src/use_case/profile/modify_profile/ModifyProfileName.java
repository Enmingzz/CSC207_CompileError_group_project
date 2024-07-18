package use_case.profile.modify_profile;

import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

/**
 * Class for modifying the user's name.
 * Implements the ModifyProfileNameInterface to handle the action of updating the user's name.
 */
public class ModifyProfileName implements ModifyProfileNameInterface {

    private final UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface;
    private final UserReadDataAccessInterface userReadDataAccessInterface;

    /**
     * Constructs a ModifyProfileName with the given data access interfaces.
     *
     * @param userUpdateNameDataAccessInterface the data access interface for updating user names
     * @param userReadDataAccessInterface the data access interface for reading user data
     */
    public ModifyProfileName(UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface,
                             UserReadDataAccessInterface userReadDataAccessInterface) {
        this.userUpdateNameDataAccessInterface = userUpdateNameDataAccessInterface;
        this.userReadDataAccessInterface = userReadDataAccessInterface;
    }

    /**
     * Executes the action of updating the user's name.
     * Checks if the new name is different from the old name and updates it if necessary.
     *
     * @param user the user whose name is to be updated
     * @return true if the name was successfully updated, false if the name remained unchanged
     * @throws SQLException if a database access error occurs
     */

    public boolean execute(User user) throws SQLException {
        User oldUser = userReadDataAccessInterface.getUser(user.getStudentNumber());
        String oldName = oldUser.getName();
        if (oldName.equals(user.getName())) {
            return false;
        } else {
            userUpdateNameDataAccessInterface.updateUserName(user, user.getName());
            return true;
        }
    }
}
