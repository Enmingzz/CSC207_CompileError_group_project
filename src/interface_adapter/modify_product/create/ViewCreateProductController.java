package interface_adapter.modify_product.create;

import entity.user.User;
import use_case.modify_product.ViewCreateProductInputBoundary;
import use_case.modify_product.ViewCreateProductInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for handling the process of viewing the create product page.
 *
 * This controller interacts with the use case boundary to retrieve the necessary data for the
 * create product page based on the provided user information.
 */
public class ViewCreateProductController {
    private final ViewCreateProductInputBoundary viewCreateProductInteractor;

    /**
     * Constructs a ViewCreateProductController with the specified input boundary.
     *
     * @param viewCreateProductInteractor The use case boundary for viewing the create product page.
     */
    public ViewCreateProductController(ViewCreateProductInputBoundary viewCreateProductInteractor) {
        this.viewCreateProductInteractor = viewCreateProductInteractor;
    }

    /**
     * Executes the process to retrieve data for viewing the create product page.
     *
     * This method creates an input data object with the user information and calls the
     * use case boundary to execute the operation.
     *
     * @param user The user for whom the create product page is to be viewed.
     * @throws SQLException If there is a database access error.
     * @throws IOException  If there is an I/O error.
     */
    public void execute(User user) throws SQLException, IOException {
        ViewCreateProductInputData viewCreateProductInputData = new ViewCreateProductInputData(user);
        viewCreateProductInteractor.execute(viewCreateProductInputData);
    }
}
