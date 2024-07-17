package use_case.profile.modify_profile;

import entity.user.User;

/**
 * Represents the input data for viewing the modify profile page.
 * Contains the user information to be displayed on the modify profile page.
 */
public class ViewModifyProfileInputData {

    private final User user;

    /**
     * Constructs a ViewModifyProfileInputData object with the given user.
     *
     * @param user the user whose profile is to be displayed
     */
    public ViewModifyProfileInputData(User user) {
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
