package use_case.login;

import entity.user.User;

public class LoginOutputData {
    User user;

    public LoginOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
