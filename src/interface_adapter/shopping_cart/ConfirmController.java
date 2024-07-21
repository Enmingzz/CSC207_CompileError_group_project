package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.ConfirmInputData;
import use_case.shopping_cart.ConfirmInputBoundary;

/**
 * Controller for confirming an action in the shopping cart, responsible for handling user interactions and invoking the use case.
 */
public class ConfirmController {

    private final ConfirmInputBoundary confirmInteractor;

    /**
     * Constructs a {@link ConfirmController} with the specified interactor.
     *
     * @param confirmInteractor the interactor to handle the confirmation logic
     */
    public ConfirmController(ConfirmInputBoundary confirmInteractor) {
        this.confirmInteractor = confirmInteractor;
    }

    /**
     * Executes the confirm action for the specified user and product.
     *
     * @param user the user performing the confirmation
     * @param product the product to be confirmed
     * @throws Exception if an error occurs during the confirmation process
     */
    public void execute(User user, Product product) throws Exception {
        ConfirmInputData confirmInputData = new ConfirmInputData(user, product);

        confirmInteractor.confirm(confirmInputData);
    }
}