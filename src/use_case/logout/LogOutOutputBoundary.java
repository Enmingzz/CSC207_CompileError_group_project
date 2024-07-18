package use_case.logout;

/**
 * Interface for the LogOutPresenter.
 * Provides a method to prepare the view for a successful logout.
 */

public interface LogOutOutputBoundary {

    /**
     * Prepares the view for a successful logout.
     *
     * @param logOutOutputData the output data for the logout process
     */
    void prepareSuccessfulView(LogOutOutputData logOutOutputData);
}
