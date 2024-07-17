package use_case.logout;

/**
 * Interface for the LogOutInteractor.
 * Provides a method to execute the logout process with the given input data.
 */

public interface LogOutInputBoundary {

    /**
     * Executes the logout process.
     *
     * @param logOutInputData the input data for the logout process
     */
    void execute(LogOutInputData logOutInputData);
}
