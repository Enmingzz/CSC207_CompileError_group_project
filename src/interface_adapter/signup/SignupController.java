package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import java.sql.SQLException;

/**
 * Controller class for the signup process.
 * It interacts with the use case interactor to execute the signup action.
 */
public class SignupController {
    final SignupInputBoundary signupUseCaseInteractor;

    /**
     * Constructs a SignupController with the given use case interactor.
     *
     * @param signupUseCaseInteractor the interactor for the signup use case
     */
    public SignupController(SignupInputBoundary signupUseCaseInteractor) {
        this.signupUseCaseInteractor = signupUseCaseInteractor;
    }

    /**
     * Executes the signup process.
     * Creates a signup input data object with the provided parameters and passes it to the interactor for processing.
     *
     * @param username                the username
     * @param password                the password
     * @param repeatPassword          the repeated password
     * @param emailAddress            the email address
     * @param inputVerificationCode   the input verification code
     * @param generatedVerificationCode the generated verification code
     * @param studentNumber           the student number
     * @throws SQLException if a database access error occurs
     */
    public void execute(String username, String password, String repeatPassword,
                        String emailAddress, String inputVerificationCode, String generatedVerificationCode
            , String studentNumber) throws SQLException {
        SignupInputData signupInputData = new SignupInputData(username, password,
                repeatPassword, emailAddress, inputVerificationCode, generatedVerificationCode, studentNumber);
        signupUseCaseInteractor.execute(signupInputData);
    }
}
