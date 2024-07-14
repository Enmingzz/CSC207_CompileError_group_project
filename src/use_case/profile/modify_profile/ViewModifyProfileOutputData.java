package use_case.profile.modify_profile;

import entity.user.User;

public class ViewModifyProfileOutputData {

    private User user;

    public ViewModifyProfileOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
