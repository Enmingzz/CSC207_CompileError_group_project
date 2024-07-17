package use_case.profile.view_profile;

import entity.user.User;

/**
 * Represents the input data for viewing the profile.
 * Contains the user information to be displayed on the profile page.
 */

public class ViewProfileInputData {

    private final User user;

    /**
     * Constructs a ViewProfileInputData object with the given user.
     *
     * @param user the user whose profile is to be displayed
     */
    public ViewProfileInputData(User user) {
        this.user = user;
    }

    /**
     * Returns the user whose profile is to be displayed.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
