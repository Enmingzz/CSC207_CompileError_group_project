package interface_adapter.profile.modify_profile;

import entity.user.User;
import use_case.profile.modify_profile.ModifyProfileInputBoundary;
import use_case.profile.modify_profile.ModifyProfileInputData;
import use_case.profile.modify_profile.ViewModifyProfileInputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileInputData;

import java.io.IOException;
import java.sql.SQLException;
/**
 * Controller for viewing the modify profile page, responsible for handling user interactions and invoking the use case.
 */
public class ViewModifyProfileController {

    private final ViewModifyProfileInputBoundary viewModifyProfileInteractor;
    /**
     * Constructs a {@link ViewModifyProfileController} with the specified interactor.
     *
     * @param modifyProfileInteractor the interactor to handle the view modify profile logic
     */
    public ViewModifyProfileController(ViewModifyProfileInputBoundary modifyProfileInteractor) {
        this.viewModifyProfileInteractor = modifyProfileInteractor;
    }
    /**
     * Executes the view modify profile use case for the specified user.
     *
     * @param user the user whose profile modification view is to be executed
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public void execute(User user) throws SQLException, IOException {
        ViewModifyProfileInputData viewModifyProfileInputData =
                new ViewModifyProfileInputData(user);
        viewModifyProfileInteractor.execute(viewModifyProfileInputData);
    }

}
