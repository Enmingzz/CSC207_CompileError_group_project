package use_case.signup;

/**
 * Interface for the signup output boundary.
 * Provides methods to present the view for successful and failed signup attempts.
 */

public interface SignupOutputBoundary {

    /**
     * Presents the view for a successful signup attempt.
     *
     * @param response the output data for the successful signup
     */
    void presentSuccessfulView(SignupOutputData response);

    /**
     * Presents the view for a failed signup attempt.
     *
     * @param response the output data for the failed signup
     */
    void presentFailedView(SignupOutputData response);
}
