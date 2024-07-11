package use_case.login;

import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.awt.*;
import java.sql.SQLException;

/**
 * Read user from database by studentNumber and check if user does exist by studentNumber does exist and password match.
 * @author CompileError group
 */

public class LoginInteractor implements LoginInputBoundary{

    final UserReadDataAccessInterface userReadDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(UserReadDataAccessInterface userReadDataAccessObject, LoginOutputBoundary loginPresenter) {
        this.userReadDataAccessObject = userReadDataAccessObject;
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void execute(LoginInputData loginInputData) throws SQLException {
        User user = userReadDataAccessObject.getUser(loginInputData.getStudentNumber());
        if (user == null){
            loginPresenter.prepareFailedView("Can not find user");
        }
        else if(user.getPassword().equals(loginInputData.getPassword())) {
            loginPresenter.prepareSuccessfulView(new LoginOutputData(user));
        }
        else if(!user.getPassword().equals(loginInputData.getPassword())){
            loginPresenter.prepareFailedView("Passwords do not match");
        }
    }
}
