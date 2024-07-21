package interface_adapter.profile.view_profile;

import entity.product.Product;
import entity.user.User;
import entity.user.UserFactory;

import java.util.ArrayList;

/**
 * Represents the state for viewing the user's profile, including the user and messages.
 */
public class ViewProfileState {

    private User user;
    private String message = "";

    /**
     * Constructs a {@link ViewProfileState} with the specified user factory.
     *
     * @param commonUserFactory the factory to create the user
     */
    public ViewProfileState(UserFactory commonUserFactory) {
        this.user = commonUserFactory.createUser("", "", "", 0, "");
    }
    /**
     * Constructs a {@link ViewProfileState} with the specified user.
     *
     * @param user the user to initialize the state with
     */
    public ViewProfileState(User user) {
        this.user = user;
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
     * Gets the message related to the profile view.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * Sets the current user.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Sets the message related to the profile view.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
