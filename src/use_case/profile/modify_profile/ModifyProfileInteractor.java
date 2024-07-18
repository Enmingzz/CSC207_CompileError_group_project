package use_case.profile.modify_profile;

import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;

import java.sql.SQLException;

/**
 * Interactor class for modifying a profile.
 * Implements the ModifyProfileInputBoundary interface to handle the action of modifying a profile.
 */

public class ModifyProfileInteractor implements ModifyProfileInputBoundary {

    private final ModifyProfileNameInterface modifyProfileName;
    private final ModifyProfilePasswordInterface modifyProfilePassword;
    private final ModifyProfileOutputBoundary modifyProfilePresenter;

    /**
     * Constructs a ModifyProfileInteractor with the given data access interfaces and presenter.
     *
     * @param userUpdateNameDataAccessInterface the data access interface for updating user names
     * @param userUpdatePasswordDataAccessInterface the data access interface for updating user passwords
     * @param userReadDataAccessInterface the data access interface for reading user data
     * @param modifyProfilePresenter the presenter for modifying profiles
     */

    public ModifyProfileInteractor(UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface,
                                   UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface,
                                   UserReadDataAccessInterface userReadDataAccessInterface,
                                   ModifyProfileOutputBoundary modifyProfilePresenter) {
        this.modifyProfileName = new ModifyProfileName(userUpdateNameDataAccessInterface, userReadDataAccessInterface);
        this.modifyProfilePassword = new ModifyProfilePassword(userReadDataAccessInterface, userUpdatePasswordDataAccessInterface);
        this.modifyProfilePresenter = modifyProfilePresenter;
    }

    /**
     * Executes the action of modifying a profile.
     * Updates the user's name and/or password based on the input data, and passes the result to the presenter.
     *
     * @param modifyProfileInputData the input data for modifying the profile
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void execute(ModifyProfileInputData modifyProfileInputData) throws SQLException {
        boolean passwordFlag = modifyProfilePassword.execute(modifyProfileInputData.getUser());
        boolean userNameFlag = modifyProfileName.execute(modifyProfileInputData.getUser());

        if (passwordFlag && userNameFlag) {
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Have successfully changed username and password");
            modifyProfilePresenter.prepareSuccessfulView(modifyProfileOutputData);
        } else if (!passwordFlag && userNameFlag) {
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Have successfully changed username");
            modifyProfilePresenter.prepareSuccessfulView(modifyProfileOutputData);
        } else if (passwordFlag && !userNameFlag) {
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Have successfully changed password");
            modifyProfilePresenter.prepareSuccessfulView(modifyProfileOutputData);
        } else {
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Did not change anything");
            modifyProfilePresenter.prepareFailedView(modifyProfileOutputData);
        }
    }
}
