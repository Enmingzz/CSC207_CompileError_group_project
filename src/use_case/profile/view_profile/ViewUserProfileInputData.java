package use_case.profile.view_profile;

import entity.user.User;

public class ViewUserProfileInputData {

    private User seller;
    private User buyer;

    public ViewUserProfileInputData(User user, User buyer) {
        this.seller = user;
        this.buyer = user;
    }

    public User getSeller() {
        return seller;
    }
    public User getBuyer(){
        return buyer;
    }

}
