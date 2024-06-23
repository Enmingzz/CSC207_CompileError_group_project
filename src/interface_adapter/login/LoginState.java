package interface_adapter.login;

/**
 * Recording information for LoginViewPage. It is initialized in LoginViewModel, and stage common information for login view.
 * @author CompileError group
 */

public class LoginState {

    private String studentNumber = "";
    private String studentNumberError = null;
    private String password = "";
    private String passwordError = null;

    public LoginState(LoginState copy) {
        studentNumber = copy.studentNumber;
        studentNumberError = copy.studentNumberError;
        password = copy.password;
        passwordError = copy.passwordError;
    }
    
    public LoginState() {}

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentNumberError() {
        return studentNumberError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStudentNumberError(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

}
