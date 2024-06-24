package use_case.shopping_cart;

import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import entity.product.Product;
import interface_adapter.shopping_cart.ShoppingCartPresenter;

import java.util.ArrayList;

public class ShowShoppingCartInteractor implements ShowShoppingCartInputBoundary{

    private final ShoppingCartPresenter presenter;
    private final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess;



    public ShowShoppingCartInteractor(ShoppingCartPresenter presenter, ShoppingCartReadDataAccessInterface
            shoppingCartReadDataAccess) {
        this.presenter = presenter;
        this.shoppingCartReadDataAccess = shoppingCartReadDataAccess;
    }

    public void execute(ShowShoppingCartInputData showShoppingCartInputData){
        ArrayList<Product> products  =
        ShowShoppingCartOutputData showShoppingCartOutputData = new ShowShoppingCartOutputData();
        presenter.prepareSuccessfulView(showShoppingCartOutputData);

    }
}
