package use_case.profile.modify_profile;

import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

/**
 * Class for modifying the user's password.
 * Implements the ModifyProfilePasswordInterface to handle the action of updating the user's password.
 */
public class ModifyProfilePassword implements ModifyProfilePasswordInterface {

    private final UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface;
    private final UserReadDataAccessInterface userReadDataAccessInterface;

    /**
     * Constructs a ModifyProfilePassword with the given data access interfaces.
     *
     * @param userReadDataAccessInterface the data access interface for reading user data
     * @param userUpdatePasswordDataAccessInterface the data access interface for updating user passwords
     */
    public ModifyProfilePassword(UserReadDataAccessInterface userReadDataAccessInterface,
                                 UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface) {
        this.userUpdatePasswordDataAccessInterface = userUpdatePasswordDataAccessInterface;
        this.userReadDataAccessInterface = userReadDataAccessInterface;
    }

    /**
     * Executes the action of updating the user's password.
     * Checks if the new password is different from the old password and updates it if necessary.
     *
     * @param user the user whose password is to be updated
     * @return true if the password was successfully updated, false if the password remained unchanged
     * @throws SQLException if a database access error occurs
     */
    public boolean execute(User user) throws SQLException {
        String oldPassword = userReadDataAccessInterface.getUser(user.getStudentNumber()).getPassword();
        if (oldPassword.equals(user.getPassword())) {
            return false;
        } else {
            userUpdatePasswordDataAccessInterface.updateUserPassword(user, user.getPassword());
            System.out.println("password to save" + user.getPassword());
            return true;
        }
    }
}
