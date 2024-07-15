package interface_adapter.profile.modify_profile;

import entity.user.User;

public class ModifyProfileState {

    private User user;

    public ModifyProfileState(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

}
