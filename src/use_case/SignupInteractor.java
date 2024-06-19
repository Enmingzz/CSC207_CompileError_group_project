package use_case;

import data_access.DatabaseUserSignupSaveDataAccessObject;
import data_access.UserSignupDataAccessInterface;
import entity.User;
import entity.UserFactory;

import java.sql.SQLException;

public class SignupInteractor implements SignupInputBoundary{
    final UserSignupDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(UserSignupDataAccessInterface userSignupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
            this.userDataAccessObject = userSignupDataAccessInterface;
            this.userPresenter = signupOutputBoundary;
            this.userFactory = userFactory;
        }
    @Override
    public void execute(SignupInputData signupInputData) throws SQLException {
        if (userDataAccessObject.existsByUTorID(signupInputData.getUtorid())) {
            userPresenter.presentFailedView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.presentFailedView("Passwords don't match.");
        } else {
            User user = userFactory.createUser(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getEmailAddress(), 0, signupInputData.getUtorid());
            userDataAccessObject.saveUser(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), user.getUtroid(), false);
            userPresenter.presentSuccessfulView(signupOutputData);
        }
    }
}
