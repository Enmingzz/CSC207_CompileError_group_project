package use_case.signup;

/**
 * Represents the input data for the signup process.
 * Contains the user information and verification codes required for signup.
 */
public class SignupInputData {
    private final String username;
    private final String password;
    private final String emailAddress;
    private final String generatedVerificationCode;
    private final String inputVerificationCode;
    private final String repeatPassword;
    private final String studentNumber;

    /**
     * Constructs a SignupInputData object with the given user information and verification codes.
     *
     * @param username the username
     * @param password the password
     * @param repeatPassword the repeated password
     * @param emailAddress the email address
     * @param generatedVerificationCode the generated verification code
     * @param inputVerificationCode the input verification code
     * @param studentNumber the student number
     */
    public SignupInputData(String username, String password, String repeatPassword, String emailAddress, String generatedVerificationCode, String inputVerificationCode, String studentNumber) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.generatedVerificationCode = generatedVerificationCode;
        this.inputVerificationCode = inputVerificationCode;
        this.repeatPassword = repeatPassword;
        this.studentNumber = studentNumber;
    }

    /**
     * Returns the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the input verification code.
     *
     * @return the input verification code
     */
    public String getInputVerificationCode() {
        return inputVerificationCode;
    }

    /**
     * Returns the generated verification code.
     *
     * @return the generated verification code
     */
    public String getGeneratedVerificationCode() {
        return generatedVerificationCode;
    }

    /**
     * Returns the email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Returns the repeated password.
     *
     * @return the repeated password
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Returns the student number.
     *
     * @return the student number
     */
    public String getStudentNumber() {
        return studentNumber;
    }
}
