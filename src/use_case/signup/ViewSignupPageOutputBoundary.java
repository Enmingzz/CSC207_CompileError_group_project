package use_case.signup;

/**
 * Interface for the presenter of viewing the signup page.
 * Provides a method to prepare the view for a successful display of the signup page.
 */

public interface ViewSignupPageOutputBoundary {

    /**
     * Prepares the view for a successful display of the signup page.
     *
     * @param viewSignupPageOutputData the output data for displaying the signup page
     */
    void prepareSuccessfulView(ViewSignupPageOutputData viewSignupPageOutputData);
}
