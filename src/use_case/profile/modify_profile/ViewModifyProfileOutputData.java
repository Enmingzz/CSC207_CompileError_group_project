package use_case.profile.modify_profile;

import entity.user.User;

/**
 * Represents the output data for viewing the modify profile page.
 * Contains the user information to be displayed on the modify profile page.
 */
public class ViewModifyProfileOutputData {

    private User user;

    /**
     * Constructs a ViewModifyProfileOutputData object with the given user.
     *
     * @param user the user whose profile is to be displayed
     */
    public ViewModifyProfileOutputData(User user) {
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

    /**
     * Sets the user whose profile is to be displayed.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
