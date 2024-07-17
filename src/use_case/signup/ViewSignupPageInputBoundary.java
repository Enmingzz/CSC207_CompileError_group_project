package use_case.signup;

/**
 * Interface for viewing the signup page input boundary.
 * Provides a method to execute the action of displaying the signup page.
 */

public interface ViewSignupPageInputBoundary {

    /**
     * Executes the action of displaying the signup page.
     *
     * @param viewSignupPageInputData the input data for viewing the signup page
     */
    void execute(ViewSignupPageInputData viewSignupPageInputData);

}
