package interface_adapter.shopping_cart;

import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartOutputData;

public class ShoppingCartPresenter implements ShowShoppingCartOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;

    public ShoppingCartPresenter(ShoppingCartViewModel shoppingCartViewModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    public void prepareSuccessfulView(ShowShoppingCartOutputData showShoppingCartOutputData) {

    }

}
