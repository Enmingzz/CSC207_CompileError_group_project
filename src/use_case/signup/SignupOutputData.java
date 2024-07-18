package use_case.signup;

import entity.user.User;

/**
 * Represents the output data for the signup process.
 * Contains the user information and any error messages resulting from the signup attempt.
 */

public class SignupOutputData {

    private final User user;
    private final String error;

    /**
     * Constructs a SignupOutputData object with the given user and error message.
     *
     * @param user the user created or involved in the signup process
     * @param error the error message, if any, resulting from the signup attempt
     */
    public SignupOutputData(User user, String error) {
        this.user = user;
        this.error = error;
    }

    /**
     * Returns the user created or involved in the signup process.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the error message resulting from the signup attempt.
     *
     * @return the error message
     */
    public String getError() {
        return error;
    }
}
