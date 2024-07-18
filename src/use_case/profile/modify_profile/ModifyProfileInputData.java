package use_case.profile.modify_profile;

import entity.user.User;

/**
 * Represents the input data for modifying a profile.
 * Contains the user information to be modified.
 */
public class ModifyProfileInputData {

    private final User user;

    /**
     * Constructs a ModifyProfileInputData object with the given user.
     *
     * @param user the user whose profile is to be modified
     */
    public ModifyProfileInputData(User user) {
        this.user = user;
    }

    /**
     * Returns the user whose profile is to be modified.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

}
