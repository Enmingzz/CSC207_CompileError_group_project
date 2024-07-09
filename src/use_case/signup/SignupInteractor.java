package use_case.signup;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;

/**
 *Receive Student's information from the SignUpView, then process those information and executes
 * different actions.
 * If user does not exist, password does match and validation code does match, then execute the
 * successful view presenter.
 * Otherwise, executes failed view presenter, with different error message.
 */

public class SignupInteractor implements SignupInputBoundary{
    final UserCreateDataAccessInterface userCreateDataAccessObject;
    final UserReadDataAccessInterface userReadDataAccessObject;
    final SignupOutputBoundary signupPresenter;
    final UserFactory userFactory;

    /**
     * @param userCreateDataAccessObject A DAO used to save a user into databases.
     * @param userReadDataAccessObject A DAO used to read users from database.
     * @param signupPresenter initialize userPresenter with a signupPresenter but with upcasting
     *                        to SignupOutputBoundary
     * @param userFactory Used to create a commonUser.
     */

    public SignupInteractor(UserCreateDataAccessInterface userCreateDataAccessObject, UserReadDataAccessInterface userReadDataAccessObject,
                            SignupOutputBoundary signupPresenter,
                            UserFactory userFactory) {
            this.userCreateDataAccessObject = userCreateDataAccessObject;
            this.userReadDataAccessObject = userReadDataAccessObject;
            this.signupPresenter = signupPresenter;
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
        User user = userFactory.createUser(signupInputData.getUsername(), signupInputData.getPassword(),
                signupInputData.getEmailAddress(), 0, signupInputData.getStudentNumber());
        //System.out.println(signupInputData.getGeneratedVerificationCode());
        if (existsByStudentNumber(signupInputData)) {
            SignupOutputData signupOutputData = new SignupOutputData(user, "user already exists");
            signupPresenter.presentFailedView(signupOutputData);
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            SignupOutputData signupOutputData = new SignupOutputData(user, "user already exists");
            signupPresenter.presentFailedView(signupOutputData);
        }else if(signupInputData.getGeneratedVerificationCode() == ""){
            SignupOutputData signupOutputData = new SignupOutputData(user, "Need to send verification code fist");
            signupPresenter.presentFailedView(signupOutputData);
        }
        else if (!signupInputData.getInputVerificationCode().equals(signupInputData.getGeneratedVerificationCode())){
            SignupOutputData signupOutputData = new SignupOutputData(user, "Wrong verification code");
            signupPresenter.presentFailedView(signupOutputData);
        }else {
            userCreateDataAccessObject.saveUser(user);
            SignupOutputData signupOutputData = new SignupOutputData(user, "successful");
            signupPresenter.presentSuccessfulView(signupOutputData);
        }
    }
}
