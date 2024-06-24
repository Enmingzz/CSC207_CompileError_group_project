package use_case.profile;

import data_access.interfaces.UserReadDataAccessInterface;
import data_access.interfaces.UserUpdateNameDataAccessInterface;
import data_access.interfaces.UserUpdatePasswordDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class ModifyProfileInteractor implements ModifyProfileInputBoundary {

    private final ModifyProfileNameInteractor modifyProfileNameInteractor;
    private final ModifyProfilePasswordInteractor modifyProfilePasswordInteractor;
    private final ModifyProfileOutputBoundary modifyProfilePresenter;

    public ModifyProfileInteractor(UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface, UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface, UserReadDataAccessInterface userReadDataAccessInterface, ModifyProfileOutputBoundary modifyProfilePresenter) {
        this.modifyProfileNameInteractor = new ModifyProfileNameInteractor(userUpdateNameDataAccessInterface, userReadDataAccessInterface);
        this.modifyProfilePasswordInteractor = new ModifyProfilePasswordInteractor(userReadDataAccessInterface, userUpdatePasswordDataAccessInterface);
        this.modifyProfilePresenter = modifyProfilePresenter;
    }

    public void execute(User user) throws SQLException {
        boolean passwordFlag = modifyProfilePasswordInteractor.execute(user);
        boolean userNameFlag = modifyProfileNameInteractor.execute(user);
        if(passwordFlag && userNameFlag){
            modifyProfilePresenter.prepareSuccessfulView("Have successfully changed username and password");
        }
        else if(!passwordFlag && userNameFlag){
            modifyProfilePresenter.prepareSuccessfulView("Have successfully changed username");
        }
        else if(passwordFlag && !userNameFlag){
            modifyProfilePresenter.prepareSuccessfulView("Have successfully changed password");
        }
        else{
            modifyProfilePresenter.prepareFailedView("Did not change anything");
        }
    }
}
