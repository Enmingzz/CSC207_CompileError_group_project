package interface_adapter.login;

/**
 * Holds the state information for the login view.
 * It is initialized in LoginViewModel and contains information for the login view, such as the student number and password.
 * This class also includes error messages for the student number and password fields.
 */
public class LoginState {

    private String studentNumber = "";
    private String studentNumberError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Copy constructor. Creates a new LoginState by copying the fields from another LoginState.
     *
     * @param copy the LoginState to copy
     */
    public LoginState(LoginState copy) {
        studentNumber = copy.studentNumber;
        studentNumberError = copy.studentNumberError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    /**
     * Default constructor. Creates a new LoginState with default values.
     */
    public LoginState() {}

    /**
     * Returns the student number.
     *
     * @return the student number
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Returns the student number error message.
     *
     * @return the student number error message
     */
    public String getStudentNumberError() {
        return studentNumberError;
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
     * Sets the student number.
     *
     * @param studentNumber the new student number
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Sets the student number error message.
     *
     * @param studentNumberError the new student number error message
     */
    public void setStudentNumberError(String studentNumberError) {
        this.studentNumberError = studentNumberError;
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

}
