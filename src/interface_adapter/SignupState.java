package interface_adapter;

public class SignupState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String repeatPassword = "";
    private String repeatPasswordError = null;
    private String verificationCode = "";
    private String verificationCodeError = null;
    private String email = "";

    public SignupState(SignupState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        repeatPassword = copy.repeatPassword;
        repeatPasswordError = copy.repeatPasswordError;
        verificationCode = copy.verificationCode;
        verificationCodeError = copy.verificationCodeError;
        email = copy.email;
    }

    public SignupState() {}

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public String getVerificationCodeError() {
        return verificationCodeError;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setVerificationCodeError(String verificationCodeError) {
        this.verificationCodeError = verificationCodeError;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
