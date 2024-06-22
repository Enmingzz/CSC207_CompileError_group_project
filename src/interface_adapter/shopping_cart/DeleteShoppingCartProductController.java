package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.DeleteShoppingCartProductInputData;
import use_case.shopping_cart.DeleteShoppingCartProductInputBoundary;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteShoppingCartProductController {
    final DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor;
    public DeleteShoppingCartProductController(DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor) {
        this.deleteShoppingCartProductInteractor = deleteShoppingCartProductInteractor;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        DeleteShoppingCartProductInputData deleteShoppingCartProductInputData = new DeleteShoppingCartProductInputData(
                user, product);
        deleteShoppingCartProductInteractor.deleteShoppingCartProduct(deleteShoppingCartProductInputData);
    }
}
