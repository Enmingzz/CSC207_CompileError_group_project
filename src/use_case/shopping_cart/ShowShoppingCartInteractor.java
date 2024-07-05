package use_case.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.shopping_cart.ShoppingCart;
import interface_adapter.shopping_cart.ShoppingCartPresenter;

import java.io.IOException;
import java.sql.SQLException;

public class ShowShoppingCartInteractor implements ShowShoppingCartInputBoundary{

    private final ShoppingCartPresenter presenter;
    private final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess;

    /**
     * @param presenter "use the shopping presenter to prepare the successful view"
     * @param shoppingCartReadDataAccess "Get shopping by using the student number in user"
     */

    public ShowShoppingCartInteractor(ShoppingCartPresenter presenter, ShoppingCartReadDataAccessInterface
            shoppingCartReadDataAccess) {
        this.presenter = presenter;
        this.shoppingCartReadDataAccess = shoppingCartReadDataAccess;
    }

    public void execute(ShowShoppingCartInputData showShoppingCartInputData) throws SQLException, IOException {
        ShoppingCart shoppingCart =
                shoppingCartReadDataAccess.getShoppingCart(showShoppingCartInputData.getUser().getStudentNumber());
        ShowShoppingCartOutputData showShoppingCartOutputData =
                new ShowShoppingCartOutputData(showShoppingCartInputData.getUser(), shoppingCart);
        presenter.prepareSuccessfulView(showShoppingCartOutputData);

    }
}
