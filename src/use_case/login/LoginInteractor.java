package use_case.login;

import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.User;
import java.sql.SQLException;

/**
 * Interactor class for the login process.
 * Implements the LoginInputBoundary interface to handle the login use case logic.
 * Interacts with the user data access object and the login presenter.
 */

public class LoginInteractor implements LoginInputBoundary {

    final UserReadDataAccessInterface userReadDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    /**
     * Constructs a LoginInteractor with the given user data access object and login presenter.
     *
     * @param userReadDataAccessObject the data access object for reading user data
     * @param loginPresenter the presenter for the login process
     */
    public LoginInteractor(UserReadDataAccessInterface userReadDataAccessObject, LoginOutputBoundary loginPresenter) {
        this.userReadDataAccessObject = userReadDataAccessObject;
        this.loginPresenter = loginPresenter;
    }

    /**
     * Executes the login process with the given input data.
     *
     * @param loginInputData the input data for the login process
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void execute(LoginInputData loginInputData) throws SQLException {
        User user = userReadDataAccessObject.getUser(loginInputData.getStudentNumber());
        if (user == null) {
            loginPresenter.prepareFailedView("Cannot find user");
        } else if (user.getPassword().equals(loginInputData.getPassword())) {
            loginPresenter.prepareSuccessfulView(new LoginOutputData(user));
        } else {
            loginPresenter.prepareFailedView("Passwords do not match");
        }
    }
}
