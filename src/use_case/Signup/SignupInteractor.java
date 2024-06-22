package use_case.Signup;

import data_access.interfaces.UserCreateDataAccessInterface;
import data_access.interfaces.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;

public class SignupInteractor implements SignupInputBoundary{
    final UserCreateDataAccessInterface userCreateDataAccessObject;
    final UserReadDataAccessInterface userReadDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(UserCreateDataAccessInterface userCreateDataAccessObject, UserReadDataAccessInterface userReadDataAccessObject,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
            this.userCreateDataAccessObject = userCreateDataAccessObject;
            this.userReadDataAccessObject = userReadDataAccessObject;
            this.userPresenter = signupOutputBoundary;
            this.userFactory = userFactory;
        }


    public boolean existsByStudentNumber(SignupInputData signupInputData) throws SQLException {
        User user = userReadDataAccessObject.getUser(signupInputData.getStudentNumber());
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(SignupInputData signupInputData) throws SQLException {
        //System.out.println(signupInputData.getGeneratedVerificationCode());
        if (existsByStudentNumber(signupInputData)) {
            userPresenter.presentFailedView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.presentFailedView("Passwords don't match.");
        }else if(signupInputData.getGeneratedVerificationCode() == ""){
            userPresenter.presentFailedView("Need to send verification code fist.");
        }
        else if (!signupInputData.getInputVerificationCode().equals(signupInputData.getGeneratedVerificationCode())){
            userPresenter.presentFailedView("Wrong verification code.");
        }else {
            User user = userFactory.createUser(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getEmailAddress(), 0, signupInputData.getStudentNumber());
            userCreateDataAccessObject.saveUser(user);
            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), user.getStudentNumber(), false);
            userPresenter.presentSuccessfulView(signupOutputData);
        }
    }
}
