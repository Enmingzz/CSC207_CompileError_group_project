package interface_adapter.profile.modify_profile;

import entity.user.User;
import entity.user.UserFactory;
/**
 * Represents the state for modifying the user's profile, including the user, modification status, and messages.
 */
public class ModifyProfileState {

    private User user;
    private String message = "";
    private boolean modified = false;

    /**
     * Constructs a {@link ModifyProfileState} with the specified user factory.
     *
     * @param userFactory the factory to create the user
     */
    public ModifyProfileState(UserFactory userFactory) {
        this.user = userFactory.createUser("", "", "", 0, "");
    }

    /**
     * Gets the current user.
     *
     * @return the current user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the current user.
     *
     * @param user the user to set
     */
    public void setUser(User user){
        this.user = user;
    }

    /**
     * Checks if the profile has been modified.
     *
     * @return true if the profile has been modified, false otherwise
     */
    public boolean getModified() {return modified;}

    /**
     * Sets the modification status of the profile.
     *
     * @param modified the modification status to set
     */
    public void setModified(boolean modified){this.modified = modified;}

    /**
     * Gets the message related to profile modification.
     *
     * @return the modification message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message related to profile modification.
     *
     * @param message the modification message to set
     */
    public void setMessage(String message){
        this.message = message;
    }

}
