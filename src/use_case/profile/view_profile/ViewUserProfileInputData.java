package use_case.profile.view_profile;

import entity.user.User;

public class ViewUserProfileInputData {

    private final String sellerStudentNumber;
    private User buyer;

    public ViewUserProfileInputData(String sellerStudentNumber, User buyer) {
        this.sellerStudentNumber = sellerStudentNumber;
        this.buyer = buyer;
    }

    public String getSellerStudentNumber() {
        return sellerStudentNumber;
    }
    public User getBuyer(){
        return buyer;
    }

}
