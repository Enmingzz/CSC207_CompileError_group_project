package interface_adapter.profile.view_profile;

import entity.product.Product;
import entity.user.User;
import entity.user.UserFactory;

import java.util.ArrayList;

public class ViewProfileState {

    private User user;
    private String message = "";

    public ViewProfileState(UserFactory commonUserFactory) {
        this.user = commonUserFactory.createUser("", "", "", 0, "");
    }

    public ViewProfileState(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
