package use_case.signup;

/**
 * Interface for the presenter of email verification.
 * Provides a method to prepare the view for displaying the email verification.
 */
public interface EmailVerificationOutputBoundary {

    /**
     * Prepares the view for displaying the email verification.
     *
     * @param emailVerificationOutputData the output data for the email verification
     */
    void prepareView(EmailVerificationOutputData emailVerificationOutputData);
}
