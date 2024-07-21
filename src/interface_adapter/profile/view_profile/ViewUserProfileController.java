package interface_adapter.profile.view_profile;

import entity.user.User;
import use_case.profile.view_profile.ViewUserProfileInputData;
/**
 * Controller for viewing another user's profile, responsible for handling user interactions and invoking the use case.
 */
public class ViewUserProfileController {
    /**
     * Executes the view user profile use case for the specified seller and buyer.
     *
     * @param sellerStudentNumber the student number of the seller
     * @param buyer the user who is viewing the profile
     */
    public void execute(String sellerStudentNumber, User buyer) {
        ViewUserProfileInputData viewUserProfileInputData= new ViewUserProfileInputData(sellerStudentNumber, buyer);
    }

}
