package use_case.login;

import entity.user.User;

/**
 * Pass user to LoginPresenter, so the main page knows who logged in.
 * @author CompileError group
 */

public class LoginOutputData {
    User user;

    public LoginOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
