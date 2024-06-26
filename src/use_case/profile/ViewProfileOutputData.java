package use_case.profile;

import entity.user.User;

public class ViewProfileOutputData {

    private final User user;

    public ViewProfileOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
