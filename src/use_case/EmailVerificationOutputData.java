package use_case;

public class EmailVerificationOutputData {

    private String verificationCode;

    public EmailVerificationOutputData(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
