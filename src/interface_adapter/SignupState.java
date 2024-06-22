package interface_adapter;

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

    public String getGeneratedVerificationCode() {
        return generatedVerificationCode;
    }

    public String getInputVerificationCode() {
        return inputVerificationCode;
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

    public void setGeneratedVerificationCode(String generatedVerificationCode) {
        this.generatedVerificationCode = generatedVerificationCode;
    }

    public void setInputVerificationCode(String inputVerificationCode) {
        this.inputVerificationCode = inputVerificationCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
