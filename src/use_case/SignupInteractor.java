package use_case;

import data_access.UserCreateDataAccessInterface;
import entity.User;
import entity.UserFactory;

import java.sql.SQLException;

public class SignupInteractor implements SignupInputBoundary{
    final UserCreateDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(UserCreateDataAccessInterface userCreateDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
            this.userDataAccessObject = userCreateDataAccessInterface;
            this.userPresenter = signupOutputBoundary;
            this.userFactory = userFactory;
        }
    @Override
    public void execute(SignupInputData signupInputData) throws SQLException {
        if (userDataAccessObject.existsByUserID(signupInputData.getUtorid())) {
            userPresenter.presentFailedView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.presentFailedView("Passwords don't match.");
        } else {
            User user = userFactory.createUser(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getEmailAddress(), 0, signupInputData.getUtorid());
            userDataAccessObject.saveUser(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), user.getStudentNumber(), false);
            userPresenter.presentSuccessfulView(signupOutputData);
        }
    }
}
