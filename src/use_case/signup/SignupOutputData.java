package use_case.signup;

import entity.user.User;

public class SignupOutputData {
    private final User user;
    private final String error;

    public SignupOutputData(User user, String error) {
        this.user = user;
        this.error = error;
    }

    public User getUser() {
        return user;
    }

    public String getError() {
        return error;
    }
}
