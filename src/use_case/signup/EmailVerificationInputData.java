package use_case.signup;

public class EmailVerificationInputData {
    private String email;

    public EmailVerificationInputData(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}