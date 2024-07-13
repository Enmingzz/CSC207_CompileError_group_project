package use_case.profile.modify_profile;

import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;

import java.sql.SQLException;

public class ModifyProfileInteractor implements ModifyProfileInputBoundary {

    private final ModifyProfileNameInterface modifyProfileName;
    private final ModifyProfilePasswordInterface modifyProfilePassword;
    private final ModifyProfileOutputBoundary modifyProfilePresenter;

    public ModifyProfileInteractor(UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface,
                                   UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface,
                                   UserReadDataAccessInterface userReadDataAccessInterface,
                                   ModifyProfileOutputBoundary modifyProfilePresenter) {
        this.modifyProfileName = new ModifyProfileName(userUpdateNameDataAccessInterface,
                userReadDataAccessInterface);
        this.modifyProfilePassword = new ModifyProfilePassword(userReadDataAccessInterface,
                userUpdatePasswordDataAccessInterface);
        this.modifyProfilePresenter = modifyProfilePresenter;
    }

    public void execute(ModifyProfileInputData modifyProfileInputData) throws SQLException {
        boolean passwordFlag = modifyProfilePassword.execute(modifyProfileInputData.getUser());
        boolean userNameFlag = modifyProfileName.execute(modifyProfileInputData.getUser());
        if(passwordFlag && userNameFlag){
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Have " +
                    "successfully changed username and password");
            modifyProfilePresenter.prepareSuccessfulView(modifyProfileOutputData);
        }
        else if(!passwordFlag && userNameFlag){
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Have " +
                    "successfully changed username");
            modifyProfilePresenter.prepareSuccessfulView(modifyProfileOutputData);
        }
        else if(passwordFlag && !userNameFlag){
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Have " +
                    "successfully changed password");
            modifyProfilePresenter.prepareSuccessfulView(modifyProfileOutputData);
        }
        else{
            ModifyProfileOutputData modifyProfileOutputData = new ModifyProfileOutputData("Did " +
                    "not change anything");
            modifyProfilePresenter.prepareFailedView(modifyProfileOutputData);
        }
    }
}
