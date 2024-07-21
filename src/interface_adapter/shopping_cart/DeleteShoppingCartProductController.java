package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.DeleteShoppingCartProductInputData;
import use_case.shopping_cart.DeleteShoppingCartProductInputBoundary;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for deleting a product from the shopping cart, responsible for handling user interactions and invoking the use case.
 */
public class DeleteShoppingCartProductController {

    private final DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor;

    /**
     * Constructs a {@link DeleteShoppingCartProductController} with the specified interactor.
     *
     * @param deleteShoppingCartProductInteractor the interactor to handle the deletion logic
     */
    public DeleteShoppingCartProductController(DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor) {
        this.deleteShoppingCartProductInteractor = deleteShoppingCartProductInteractor;
    }

    /**
     * Executes the delete action for the specified user and product.
     *
     * @param user the user performing the deletion
     * @param product the product to be deleted
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User user, Product product) throws SQLException, IOException {
        DeleteShoppingCartProductInputData deleteShoppingCartProductInputData = new DeleteShoppingCartProductInputData(
                user, product);
        deleteShoppingCartProductInteractor.deleteShoppingCartProduct(deleteShoppingCartProductInputData);
    }
}
