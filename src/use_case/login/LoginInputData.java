package use_case.login;

/**
 * Represents the input data for the login process.
 * Contains the student number and password provided by the user.
 */

public class LoginInputData {
    private String studentNumber;
    private String password;

    /**
     * Constructs a LoginInputData object with the given student number and password.
     *
     * @param studentNumber the student number of the user
     * @param password the password of the user
     */
    public LoginInputData(String studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
    }

    /**
     * Returns the student number.
     *
     * @return the student number
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Returns the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

}
