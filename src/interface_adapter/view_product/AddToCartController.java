package interface_adapter.view_product;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.AddShoppingCartProductInputBoundary;
import use_case.shopping_cart.AddShoppingCartProductInputData;

import java.io.IOException;
import java.sql.SQLException;

public class AddToCartController {

    final AddShoppingCartProductInputBoundary addShoppingCartProductInteractor;
    public AddToCartController(AddShoppingCartProductInputBoundary addShoppingCartProductInteractor) {
        this.addShoppingCartProductInteractor = addShoppingCartProductInteractor;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        AddShoppingCartProductInputData addShoppingCartProductInputData = new AddShoppingCartProductInputData(product,
                user);

        addShoppingCartProductInteractor.addProductToShoppingCart(addShoppingCartProductInputData);
    }
}
