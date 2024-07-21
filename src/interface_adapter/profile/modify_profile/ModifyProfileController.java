package interface_adapter.profile.modify_profile;

import entity.user.User;
import use_case.profile.modify_profile.ModifyProfileInputBoundary;
import use_case.profile.modify_profile.ModifyProfileInputData;

import java.io.IOException;
import java.sql.SQLException;
/**
 * Controller for modifying the user's profile, responsible for handling user interactions and invoking the use case.
 */
public class ModifyProfileController {

    private final ModifyProfileInputBoundary modifyProfileInteractor;

    /**
     * Constructs a {@link ModifyProfileController} with the specified interactor.
     *
     * @param modifyProfileInteractor the interactor to handle the profile modification logic
     */
    public ModifyProfileController(ModifyProfileInputBoundary modifyProfileInteractor) {
        this.modifyProfileInteractor = modifyProfileInteractor;
    }

    /**
     * Executes the modify profile use case for the specified user.
     *
     * @param user the user whose profile is to be modified
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public void execute(User user) throws SQLException, IOException {
        ModifyProfileInputData modifyProfileInputData = new ModifyProfileInputData(user);
        modifyProfileInteractor.execute(modifyProfileInputData);
    }

}
