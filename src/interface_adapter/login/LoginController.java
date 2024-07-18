package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import java.sql.SQLException;

/**
 * Controller class for the login process.
 * It interacts with the use case interactor to execute the login action.
 */

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;

    /**
     * Constructs a LoginController with the given use case interactor.
     *
     * @param loginUseCaseInteractor the interactor for the login use case
     */
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the login process.
     * Creates a login input data object with the provided student number and password,
     * and passes it to the interactor for processing.
     *
     * @param studentNumber the student number of the user
     * @param password the password of the user
     * @throws SQLException if a database access error occurs
     */

    public void execute(String studentNumber, String password) throws SQLException {
        LoginInputData loginInputData = new LoginInputData(studentNumber, password);
        loginUseCaseInteractor.execute(loginInputData);
    }
}
