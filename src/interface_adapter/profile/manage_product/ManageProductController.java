package interface_adapter.profile.manage_product;

import entity.user.User;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInputData;

import java.io.IOException;
import java.sql.SQLException;
/**
 * Controller for managing products in the user's profile, responsible for handling user interactions and invoking the use case.
 */
public class ManageProductController {

    private final ManageProductInputBoundary manageProductInteractor;
    /**
     * Constructs a {@link ManageProductController} with the specified interactor.
     *
     * @param manageProductInteractor the interactor to handle the product management logic
     */
    public ManageProductController(ManageProductInputBoundary manageProductInteractor) {
        this.manageProductInteractor = manageProductInteractor;
    }
    /**
     * Executes the manage product use case for the specified user.
     *
     * @param user the user for whom the product management is to be executed
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public void execute(User user) throws SQLException, IOException {
        ManageProductInputData manageProductInputData = new ManageProductInputData(user);
        manageProductInteractor.execute(manageProductInputData);
    }

}
