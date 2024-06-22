package use_case.login;

import data_access.interfaces.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;

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
        User user = userReadDataAccessObject.getUser(loginInputData.getUsername());
        if (user == null){
            loginPresenter.prepareFailedView();
        }
        else if(user.getPassword().equals(loginInputData.getPassword())) {
            loginPresenter.prepareSuccessfulView();
        }
        else if(!user.getPassword().equals(loginInputData.getPassword())){
            loginPresenter.prepareFailedView();
        }
    }
}
