package interface_adapter.shopping_cart;

import entity.user.User;
import entity.product.Product;
import use_case.shopping_cart.PurchaseInputData;
import use_case.shopping_cart.PurchaseInputBoundary;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for purchasing a product from the shopping cart, responsible for handling user interactions and invoking the use case.
 */
public class PurchaseController {

    private final PurchaseInputBoundary purchaseInteractor;

    /**
     * Constructs a {@link PurchaseController} with the specified interactor.
     *
     * @param purchaseInteractor the interactor to handle the purchase logic
     */
    public PurchaseController(PurchaseInputBoundary purchaseInteractor) {
        this.purchaseInteractor = purchaseInteractor;
    }

    /**
     * Executes the purchase action for the specified user and product.
     *
     * @param user the user performing the purchase
     * @param product the product to be purchased
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User user, Product product) throws SQLException, IOException {
        PurchaseInputData purchaseInputData = new PurchaseInputData(user, product);

        purchaseInteractor.purchaseProduct(purchaseInputData);
    }
}