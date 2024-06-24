package use_case.login;

import data_access.interfaces.User.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;

/**
 * Read user from database by studentNumber and check if user does exist by studentNumber does exist and password match.
 * @author CompileError group
 */

public class LoginInteractor implements LoginInputBoundary{

    final UserReadDataAccessInterface userReadDataAccessObject;
    final LoginOutputBoundary loginPresenter;
    final UserFactory userFactory;

    public LoginInteractor(UserReadDataAccessInterface userReadDataAccessObject, LoginOutputBoundary loginPresenter, UserFactory userFactory) {
        this.userReadDataAccessObject = userReadDataAccessObject;
        this.loginPresenter = loginPresenter;
        this.userFactory = userFactory;
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
