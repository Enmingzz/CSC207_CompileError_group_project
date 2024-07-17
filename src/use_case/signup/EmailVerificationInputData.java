package use_case.signup;

/**
 * Represents the input data for email verification.
 * Contains the email address to be verified.
 */
public class EmailVerificationInputData {
    private final String email;

    /**
     * Constructs an EmailVerificationInputData object with the given email address.
     *
     * @param email the email address to be verified
     */
    public EmailVerificationInputData(String email) {
        this.email = email;
    }

    /**
     * Returns the email address to be verified.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }
}
