package use_case.login;

/**
 * Interface for the ViewLoginPagePresenter.
 * Provides a method to prepare the view for a successful display of the login page.
 */

public interface ViewLoginPageOutputBoundary {

    /**
     * Prepares the view for a successful display of the login page.
     *
     * @param viewLoginPageOutputData the output data for displaying the login page
     */
    void prepareSuccessfulView(ViewLoginPageOutputData viewLoginPageOutputData);

}
