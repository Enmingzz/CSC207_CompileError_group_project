package use_case.profile.modify_profile;

import entity.user.User;

public class ModifyProfileInputData {

    private final User user;

    public ModifyProfileInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
