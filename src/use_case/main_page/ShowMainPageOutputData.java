package use_case.main_page;

import entity.user.User;

public class ShowMainPageOutputData {
    private final User user;

    public ShowMainPageOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
