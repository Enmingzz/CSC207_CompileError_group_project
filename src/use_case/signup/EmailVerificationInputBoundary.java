package use_case.signup;

/**
 * Interface for the email verification input boundary.
 * Provides a method to execute the email verification process with the given input data.
 */
public interface EmailVerificationInputBoundary {

    /**
     * Executes the email verification process.
     *
     * @param emailVerificationInputData the input data for the email verification
     * @throws Exception if an error occurs during the email verification process
     */
    void execute(EmailVerificationInputData emailVerificationInputData) throws Exception;
}
