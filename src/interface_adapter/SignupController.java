package interface_adapter;

import use_case.SignupInputBoundary;
import use_case.SignupInputData;

import java.sql.SQLException;

public class SignupController {
    final SignupInputBoundary SignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.SignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password, String repeatPassword, String emailAddress, String inputVerificationCode, String generatedVerificationCode, String studentNumber) throws SQLException {
        SignupInputData signupInputData = new SignupInputData(username, password, repeatPassword, emailAddress, inputVerificationCode, generatedVerificationCode, studentNumber);
        SignupUseCaseInteractor.execute(signupInputData);
    }
}
