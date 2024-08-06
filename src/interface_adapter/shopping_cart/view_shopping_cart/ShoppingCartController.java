package interface_adapter.shopping_cart.view_shopping_cart;

import entity.user.User;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for displaying the shopping cart, responsible for handling user interactions and invoking the use case.
 */
public class ShoppingCartController {

    private final ShowShoppingCartInputBoundary showShoppingCartInteractor;

    /**
     * Constructs a {@link ShoppingCartController} with the specified interactor.
     *
     * @param showShoppingCartInteractor the interactor to handle the logic for displaying the shopping cart
     */
    public ShoppingCartController(ShowShoppingCartInputBoundary showShoppingCartInteractor) {
        this.showShoppingCartInteractor = showShoppingCartInteractor;
    }

    /**
     * Executes the action to display the shopping cart for the specified user.
     *
     * @param user the user whose shopping cart is to be displayed
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User user) throws SQLException, IOException {
        ShowShoppingCartInputData showShoppingCartInputData = new ShowShoppingCartInputData(user);
        showShoppingCartInteractor.execute(showShoppingCartInputData);
    }
}