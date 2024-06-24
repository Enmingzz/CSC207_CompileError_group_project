package use_case.profile;

import data_access.interfaces.User.UserReadDataAccessInterface;
import data_access.interfaces.User.UserUpdateNameDataAccessInterface;
import data_access.interfaces.User.UserUpdatePasswordDataAccessInterface;

import java.sql.SQLException;

public class ModifyProfileInteractor implements ModifyProfileInputBoundary {

    private final ModifyProfileNameInteractor modifyProfileNameInteractor;
    private final ModifyProfilePasswordInteractor modifyProfilePasswordInteractor;
    private final ModifyProfileOutputBoundary modifyProfilePresenter;

    public ModifyProfileInteractor(UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface,
                                   UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface,
                                   UserReadDataAccessInterface userReadDataAccessInterface,
                                   ModifyProfileOutputBoundary modifyProfilePresenter) {
        this.modifyProfileNameInteractor = new ModifyProfileNameInteractor(userUpdateNameDataAccessInterface,
                userReadDataAccessInterface);
        this.modifyProfilePasswordInteractor = new ModifyProfilePasswordInteractor(userReadDataAccessInterface,
                userUpdatePasswordDataAccessInterface);
        this.modifyProfilePresenter = modifyProfilePresenter;
    }

    public void execute(ModifyProfileInputData modifyProfileInputData) throws SQLException {
        boolean passwordFlag = modifyProfilePasswordInteractor.execute(modifyProfileInputData.getUser());
        boolean userNameFlag = modifyProfileNameInteractor.execute(modifyProfileInputData.getUser());
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
