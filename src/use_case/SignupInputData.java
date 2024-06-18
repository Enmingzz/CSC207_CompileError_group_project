package use_case;

public class SignupInputData {
    final private String username;
    final private String password;
    final private String emailAddress;
    final private String verificationCode;
    final private String repeatPassword;
    final private String Utorid;

    public SignupInputData(String username, String password, String emailAddress, String verificationCode, String repeatPassword, String utorid) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.verificationCode = verificationCode;
        this.repeatPassword = repeatPassword;
        Utorid = utorid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getUtorid() {
        return Utorid;
    }
}
