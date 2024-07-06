package interface_adapter.shopping_cart;

import entity.user.User;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputData;

import java.io.IOException;
import java.sql.SQLException;

public class ShoppingCartController {

    private final ShowShoppingCartInputBoundary showShoppingCartInteractor;

    public ShoppingCartController(ShowShoppingCartInputBoundary showShoppingCartInteractor) {
        this.showShoppingCartInteractor = showShoppingCartInteractor;
    }

    public void execute(User user) throws SQLException, IOException {
        ShowShoppingCartInputData showShoppingCartInputData = new ShowShoppingCartInputData(user);
        showShoppingCartInteractor.execute(showShoppingCartInputData);
    }

}
