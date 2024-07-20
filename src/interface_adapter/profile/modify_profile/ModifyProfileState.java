package interface_adapter.profile.modify_profile;

import entity.user.User;
import entity.user.UserFactory;

public class ModifyProfileState {

    private User user;
    private String message = "";
    private boolean modified = false;

    public ModifyProfileState(UserFactory userFactory) {
        this.user = userFactory.createUser("", "", "", 0, "");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public boolean getModified() {return modified;}

    public void setModified(boolean modified){this.modified = modified;}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
