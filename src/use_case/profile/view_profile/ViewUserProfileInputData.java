package use_case.profile.view_profile;

import entity.user.User;

/**
 * Input data class for viewing a user's profile.
 * This class holds the data required to view a user's profile, including the seller's student number and the buyer's information.
 */
public class ViewUserProfileInputData {

    private final String sellerStudentNumber;
    private User buyer;

    /**
     * Constructs a ViewUserProfileInputData with the specified seller's student number and buyer information.
     *
     * @param sellerStudentNumber the student number of the seller
     * @param buyer the buyer's information
     */
    public ViewUserProfileInputData(String sellerStudentNumber, User buyer) {
        this.sellerStudentNumber = sellerStudentNumber;
        this.buyer = buyer;
    }

    /**
     * Returns the seller's student number.
     *
     * @return the seller's student number
     */
    public String getSellerStudentNumber() {
        return sellerStudentNumber;
    }

    /**
     * Returns the buyer's information.
     *
     * @return the buyer's information
     */
    public User getBuyer(){
        return buyer;
    }
}
