package use_case.signup;

/**
 * Represents the output data for email verification.
 * Contains the verification code sent to the user's email.
 */
public class EmailVerificationOutputData {

    private final String verificationCode;

    /**
     * Constructs an EmailVerificationOutputData object with the given verification code.
     *
     * @param verificationCode the verification code sent to the user's email
     */
    public EmailVerificationOutputData(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    /**
     * Returns the verification code sent to the user's email.
     *
     * @return the verification code
     */
    public String getVerificationCode() {
        return verificationCode;
    }
}
