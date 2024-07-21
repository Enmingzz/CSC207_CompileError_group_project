package interface_adapter.profile.view_profile;

import entity.user.User;
import use_case.profile.view_profile.ViewUserProfileInputData;

public class ViewUserProfileController {

    public void execute(User seller, User buyer) {
        ViewUserProfileInputData viewUserProfileInputData= new ViewUserProfileInputData(seller, buyer);
    }

}
