package interface_adapter.profile.view_profile;

import entity.user.User;
import use_case.profile.view_profile.ViewUserProfileInputBoundary;
import use_case.profile.view_profile.ViewUserProfileInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller class for the view user profile use case.
 * This class handles user input and invokes the interactor to execute the use case.
 */
public class ViewUserProfileController {

    private final ViewUserProfileInputBoundary viewUserProfileInteractor;

    /**
     * Constructs a ViewUserProfileController with the specified interactor.
     *
     * @param viewUserProfileInteractor the interactor to handle the use case execution
     */
    public ViewUserProfileController(ViewUserProfileInputBoundary viewUserProfileInteractor) {
        this.viewUserProfileInteractor = viewUserProfileInteractor;
    }

    /**
     * Executes the use case to view a user's profile.
     * Creates the input data and passes it to the interactor for execution.
     *
     * @param sellerStudentNumber the student number of the seller
     * @param buyer the buyer's information
     * @throws SQLException if there is an error accessing the database
     * @throws IOException if there is an I/O error
     */
    public void execute(String sellerStudentNumber, User buyer) throws SQLException, IOException {
        ViewUserProfileInputData viewUserProfileInputData = new ViewUserProfileInputData(sellerStudentNumber, buyer);
        viewUserProfileInteractor.execute(viewUserProfileInputData);
    }
}
