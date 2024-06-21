package interface_adapter;

import entity.product.Product;
import entity.user.User;
import use_case.DeleteShoppingCartProductInputData;
import use_case.DeleteShoppingCartProductInputBoundary;

import java.sql.SQLException;

public class DeleteShoppingCartProductController {
    final DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor;
    public DeleteShoppingCartProductController(DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor) {
        this.deleteShoppingCartProductInteractor = deleteShoppingCartProductInteractor;
    }

    public void execute(User user, Product product) throws SQLException {
        DeleteShoppingCartProductInputData deleteShoppingCartProductInputData = new DeleteShoppingCartProductInputData(
                user, product);
        deleteShoppingCartProductInteractor.deleteShoppingCartProduct(deleteShoppingCartProductInputData);
    }
}
