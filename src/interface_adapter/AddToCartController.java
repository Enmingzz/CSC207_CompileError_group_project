package interface_adapter;

import entity.product.Product;
import entity.user.User;
import use_case.AddShoppingCartProductInputBoundary;
import use_case.AddShoppingCartProductInputData;

import java.sql.SQLException;

public class AddToCartController {

    final AddShoppingCartProductInputBoundary addShoppingCartProductInteractor;
    public AddToCartController(AddShoppingCartProductInputBoundary addShoppingCartProductInteractor) {
        this.addShoppingCartProductInteractor = addShoppingCartProductInteractor;
    }

    public void execute(User user, Product product) throws SQLException {
        AddShoppingCartProductInputData addShoppingCartProductInputData = new AddShoppingCartProductInputData(product,
                user);

        addShoppingCartProductInteractor.addProductToShoppingCart(addShoppingCartProductInputData);
    }
}
