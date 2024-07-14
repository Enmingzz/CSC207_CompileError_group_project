package use_case.profile.modify_profile;

import entity.user.User;

public class ViewModifyProfileInputData {

    private final User user;

    public ViewModifyProfileInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
