package interface_adapter.profile.modify_profile;

public class ModifyProfileState {
    private String message;
    private String name;
    private String nameError;
    private String password;
    private String passwordError;

    public ModifyProfileState(ModifyProfileState copy) {
        name = copy.name;
        nameError = copy.nameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    public ModifyProfileState() {}

    public String getname() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public void setUsernameError(String nameError) {
        this.nameError = nameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}
