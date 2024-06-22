package use_case.Signup;

public class SignupInputData {
    final private String username;
    final private String password;
    final private String emailAddress;
    final private String generatedVerificationCode;
    final private String inputVerificationCode;
    final private String repeatPassword;
    final private String studentNumber;

    public SignupInputData(String username, String password, String repeatPassword, String emailAddress, String generatedVerificationCode, String inputVerificationCode, String studentNumber) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.generatedVerificationCode = generatedVerificationCode;
        this.inputVerificationCode = inputVerificationCode;
        this.repeatPassword = repeatPassword;
        this.studentNumber = studentNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getInputVerificationCode() {
        return inputVerificationCode;
    }

    public String getGeneratedVerificationCode() {
        return generatedVerificationCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getStudentNumber() {
        return studentNumber;
    }


}
