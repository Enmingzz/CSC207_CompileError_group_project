package use_case.login;

/**
 * Interface for the ViewLoginPageInteractor.
 * Provides a method to execute the action of displaying the login page.
 */

public interface ViewLoginPageInputBoundary {

    /**
     * Executes the action of displaying the login page.
     *
     * @param viewLoginPageInputData the input data for displaying the login page
     */
    void execute(ViewLoginPageInputData viewLoginPageInputData);

}
