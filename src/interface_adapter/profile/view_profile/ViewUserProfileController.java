package interface_adapter.profile.view_profile;

import entity.user.User;
import use_case.profile.view_profile.ViewUserProfileInputBoundary;
import use_case.profile.view_profile.ViewUserProfileInputData;

import java.sql.SQLException;

public class ViewUserProfileController {

    private final ViewUserProfileInputBoundary viewUserProfileInteractor;

    public ViewUserProfileController(ViewUserProfileInputBoundary viewUserProfileInteractor) {
        this.viewUserProfileInteractor = viewUserProfileInteractor;
    }

    public void execute(String sellerStudentNumber, User buyer) throws SQLException {
        ViewUserProfileInputData viewUserProfileInputData= new ViewUserProfileInputData(sellerStudentNumber, buyer);
        viewUserProfileInteractor.execute(viewUserProfileInputData);
    }

}
