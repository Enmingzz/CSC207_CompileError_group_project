package use_case.main_page;

import entity.user.User;

public class ShowMainPageInputData {

    private final User user;

    public ShowMainPageInputData(User user) {
        this.user = user;
    }

    User getUser() {
        return user;
    }

}
