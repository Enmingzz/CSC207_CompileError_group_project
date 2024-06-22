package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

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
