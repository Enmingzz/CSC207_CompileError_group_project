package use_case.login;

/**
 * Interface for the LoginPresenter.
 * Provides methods to prepare views for successful and failed login attempts.
 *
 * This interface ensures that the presentation logic is decoupled from the use case logic.
 */
public interface LoginOutputBoundary {

    /**
     * Prepares the view for a successful login attempt.
     *
     * @param response the output data for the successful login
     */
    void prepareSuccessfulView(LoginOutputData response);

    /**
     * Prepares the view for a failed login attempt.
     *
     * @param error the error message for the failed login
     */
    void prepareFailedView(String error);
}
