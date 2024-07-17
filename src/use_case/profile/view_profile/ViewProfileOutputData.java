package use_case.profile.view_profile;

import entity.user.User;

/**
 * Represents the output data for viewing the profile.
 * Contains the user information to be displayed on the profile page.
 */
public class ViewProfileOutputData {

    private final User user;

    /**
     * Constructs a ViewProfileOutputData object with the given user.
     *
     * @param user the user whose profile is to be displayed
     */
    public ViewProfileOutputData(User user) {
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
