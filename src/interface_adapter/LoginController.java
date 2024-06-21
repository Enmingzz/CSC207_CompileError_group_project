package interface_adapter;

import use_case.LoginInputBoundary;
import use_case.LoginInputData;
import use_case.SignupInputBoundary;
import use_case.SignupInputData;

import java.sql.SQLException;

public class LoginController {
    final LoginInputBoundary LoginUseCaseInteractor;
    public LoginController(LoginInputBoundary userSignupUseCaseInteractor) {
        this.LoginUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String studentNumber, String password) throws SQLException {
        LoginInputData signupInputData = new LoginInputData(studentNumber, password);
        LoginUseCaseInteractor.execute(signupInputData);
    }
}
