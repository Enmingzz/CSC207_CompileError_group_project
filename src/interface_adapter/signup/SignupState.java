package interface_adapter.signup;

import entity.user.User;

/**
 * Represents the state of a signup process.
 * Contains fields for user credentials and errors related to the signup process.
 */
public class SignupState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String repeatPassword = "";
    private String repeatPasswordError = null;
    private String generatedVerificationCode = "";
    private String inputVerificationCode = "";
    private String email = "";
    private User user;

    /**
     * Copy constructor. Creates a new SignupState by copying the fields from another SignupState.
     *
     * @param copy the SignupState to copy
     */
    public SignupState(SignupState copy) {
        this.username = copy.username;
        this.usernameError = copy.usernameError;
        this.password = copy.password;
        this.passwordError = copy.passwordError;
        this.repeatPassword = copy.repeatPassword;
        this.repeatPasswordError = copy.repeatPasswordError;
        this.generatedVerificationCode = copy.generatedVerificationCode;
        this.inputVerificationCode = copy.inputVerificationCode;
        this.email = copy.email;
    }

    /**
     * Default constructor. Creates a new SignupState with default values.
     */
    public SignupState() {}

    /**
     * Returns the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the username error message.
     *
     * @return the username error message
     */
    public String getUsernameError() {
        return usernameError;
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
     * Returns the password error message.
     *
     * @return the password error message
     */
    public String getPasswordError() {
        return passwordError;
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
     * Returns the repeated password error message.
     *
     * @return the repeated password error message
     */
    public String getRepeatPasswordError() {
        return repeatPasswordError;
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
     * Returns the input verification code.
     *
     * @return the input verification code
     */
    public String getInputVerificationCode() {
        return inputVerificationCode;
    }

    /**
     * Returns the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the username error message.
     *
     * @param usernameError the new username error message
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the password error message.
     *
     * @param passwordError the new password error message
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Sets the repeated password.
     *
     * @param repeatPassword the new repeated password
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    /**
     * Sets the repeated password error message.
     *
     * @param repeatPasswordError the new repeated password error message
     */
    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    /**
     * Sets the generated verification code.
     *
     * @param generatedVerificationCode the new generated verification code
     */
    public void setGeneratedVerificationCode(String generatedVerificationCode) {
        this.generatedVerificationCode = generatedVerificationCode;
    }

    /**
     * Sets the input verification code.
     *
     * @param inputVerificationCode the new input verification code
     */
    public void setInputVerificationCode(String inputVerificationCode) {
        this.inputVerificationCode = inputVerificationCode;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
