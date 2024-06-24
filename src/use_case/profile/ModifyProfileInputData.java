package use_case.profile;

import entity.user.User;

public class ModifyProfileInputData {

    User user;

    public ModifyProfileInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
