package interface_adapter.profile.modify_profile;

import entity.user.User;
import entity.user.UserFactory;

public class ModifyProfileState {

    private User user;

    public ModifyProfileState(UserFactory userFactory) {
        this.user = userFactory.createUser("", "", "", 0, "");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

}
