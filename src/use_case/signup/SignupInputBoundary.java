package use_case.signup;

import java.sql.SQLException;

/**
 * Interface for the signup input boundary.
 * Provides a method to execute the signup process with the given input data.
 */
public interface SignupInputBoundary {

    /**
     * Executes the signup process.
     *
     * @param signupInputData the input data for the signup process
     * @throws SQLException if a database access error occurs
     */
    void execute(SignupInputData signupInputData) throws SQLException;
}
