package interface_adapter.view_product;

import entity.user.User;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInputData;
import entity.product.Product;

import java.sql.SQLException;

/**
 * The ViewProductController class handles the process of viewing a product.
 * It uses the ViewProductInputBoundary to interact with the use case.
 */
public class ViewProductController {
    private final ViewProductInputBoundary viewProductInteractor;

    /**
     * Constructs a ViewProductController with the specified input boundary.
     *
     * @param viewProductInteractor the interactor for viewing a product.
     */
    public ViewProductController(ViewProductInputBoundary viewProductInteractor) {
        this.viewProductInteractor = viewProductInteractor;
    }

    /**
     * Executes the process of viewing a product.
     *
     * @param product the product to be viewed.
     * @param user the user viewing the product.
     * @throws SQLException if there is an error while interacting with the database.
     */
    public void execute(Product product, User user) throws SQLException {
        System.out.println("view product controller being called");
        ViewProductInputData viewProductInputData = new ViewProductInputData(product, user);
        viewProductInteractor.execute(viewProductInputData);
    }
}
