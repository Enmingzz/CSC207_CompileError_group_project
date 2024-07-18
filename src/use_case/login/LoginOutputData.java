package use_case.login;

import entity.user.User;

/**
 * Represents the output data for the login process.
 * Contains the user information to be passed to the LoginPresenter.
 */

public class LoginOutputData {
    private final User user;

    /**
     * Constructs a LoginOutputData object with the given user.
     *
     * @param user the user who logged in
     */
    public LoginOutputData(User user) {
        this.user = user;
    }

    /**
     * Returns the user who logged in.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
