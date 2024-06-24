package use_case.login;

/**
 * Use student number and password to be the input data and check if the user does exist.
 * @author CompileError group
 */

public class LoginInputData {
    private String studentNumber;
    private String password;

    public LoginInputData(String studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getPassword() {
        return password;
    }

}
