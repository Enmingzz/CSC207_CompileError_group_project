package use_case.login;

import java.sql.SQLException;

/**
 * Interface for the LoginInteractor.
 * Provides a method to execute the login process with the given input data.
 * This interface ensures encapsulation of the login use case logic.
 */

public interface LoginInputBoundary {
    /**
     * Executes the login process with the given input data.
     *
     * @param loginInputData the input data for the login process
     * @throws SQLException if a database access error occurs
     */
    void execute(LoginInputData loginInputData) throws SQLException;
}
