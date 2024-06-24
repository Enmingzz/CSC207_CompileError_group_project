package use_case.profile;

import data_access.interfaces.UserReadDataAccessInterface;
import data_access.interfaces.UserUpdateNameDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class ModifyProfileNameInteractor {
    private final UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface;
    private final UserReadDataAccessInterface userReadDataAccessInterface;

    public ModifyProfileNameInteractor(UserUpdateNameDataAccessInterface userUpdateNameDataAccessInterface, UserReadDataAccessInterface userReadDataAccessInterface) {
        this.userUpdateNameDataAccessInterface = userUpdateNameDataAccessInterface;
        this.userReadDataAccessInterface = userReadDataAccessInterface;
    }

    public boolean execute(User user) throws SQLException {
        User oldUser = userReadDataAccessInterface.getUser(user.getStudentNumber());
        String oldName = oldUser.getName();
        if (oldName == user.getName()) {
            return false;
        }
        else{
            userUpdateNameDataAccessInterface.updateUserName(user, user.getName());
        }
        return true;
    }
}
