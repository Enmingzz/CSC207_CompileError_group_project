package interface_adapter.view_product.add_to_cart;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.AddShoppingCartProductInputBoundary;
import use_case.shopping_cart.AddShoppingCartProductInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The AddToCartController class handles the process of adding a product to the shopping cart.
 * It uses the AddShoppingCartProductInputBoundary to interact with the use case.
 */
public class AddToCartController {

    private final AddShoppingCartProductInputBoundary addShoppingCartProductInteractor;

    /**
     * Constructs an AddToCartController with the specified input boundary.
     *
     * @param addShoppingCartProductInteractor the interactor for adding a product to the shopping cart.
     */
    public AddToCartController(AddShoppingCartProductInputBoundary addShoppingCartProductInteractor) {
        this.addShoppingCartProductInteractor = addShoppingCartProductInteractor;
    }

    /**
     * Executes the process of adding a product to the shopping cart.
     *
     * @param user the user who is adding the product to the shopping cart.
     * @param product the product to be added to the shopping cart.
     * @throws SQLException if there is an error while interacting with the database.
     * @throws IOException if there is an input/output error.
     */
    public void execute(User user, Product product) throws SQLException, IOException {
        AddShoppingCartProductInputData addShoppingCartProductInputData = new AddShoppingCartProductInputData(product, user);

        addShoppingCartProductInteractor.addProductToShoppingCart(addShoppingCartProductInputData);
    }
}
