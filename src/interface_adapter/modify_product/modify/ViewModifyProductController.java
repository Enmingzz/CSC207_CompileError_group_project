package interface_adapter.modify_product.modify;

import entity.product.Product;
import entity.user.User;
import use_case.modify_product.ViewModifyProductInputBoundary;
import use_case.modify_product.ViewModifyProductInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller responsible for handling requests to view the details of a product for modification.
 *
 * This controller interacts with the use case boundary to process the input data related to viewing a product
 * for modification, such as when a user requests to modify a product's details.
 */
public class ViewModifyProductController {

    private final ViewModifyProductInputBoundary viewModifyProductInputBoundary;

    /**
     * Constructs a ViewModifyProductController with the specified input boundary.
     *
     * @param modifyProductInputBoundary The use case boundary for processing view modify product input.
     */
    public ViewModifyProductController(ViewModifyProductInputBoundary modifyProductInputBoundary) {
        this.viewModifyProductInputBoundary = modifyProductInputBoundary;
    }

    /**
     * Executes the process of viewing a product for modification.
     *
     * @param user The user requesting to view the product for modification.
     * @param product The product to be viewed for modification.
     * @throws SQLException If a database access error occurs.
     * @throws IOException If an I/O error occurs.
     */
    public void execute(User user, Product product) throws SQLException, IOException {
        ViewModifyProductInputData viewModifyProductInputData = new ViewModifyProductInputData(user, product);
        viewModifyProductInputBoundary.execute(viewModifyProductInputData);
    }
}
