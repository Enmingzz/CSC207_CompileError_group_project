package use_case.profile.modify_profile;

import data_access.interfaces.User.UserReadDataAccessInterface;
import data_access.interfaces.User.UserUpdatePasswordDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class ModifyProfilePasswordInteractor {

    private final UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface;
    private final UserReadDataAccessInterface userReadDataAccessInterface;

    public ModifyProfilePasswordInteractor(UserReadDataAccessInterface userReadDataAccessInterface, UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessInterface) {
        this.userUpdatePasswordDataAccessInterface = userUpdatePasswordDataAccessInterface;
        this.userReadDataAccessInterface = userReadDataAccessInterface;
    }

    public boolean execute(User user) throws SQLException {
        String oldPassword = userReadDataAccessInterface.getUser(user.getStudentNumber()).getPassword();
        if(oldPassword.equals(user.getPassword())){
            return false;
        }else{
            userUpdatePasswordDataAccessInterface.updateUserPassword(user, user.getPassword());
        }
        return true;
    }
}
