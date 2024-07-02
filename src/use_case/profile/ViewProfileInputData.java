package use_case.profile;

import entity.user.User;

public class ViewProfileInputData {

    private final User user;

    public ViewProfileInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
