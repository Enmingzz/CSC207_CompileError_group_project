package interface_adapter.shopping_cart;

import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartOutputData;

public class ShoppingCartPresenter implements ShowShoppingCartOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShoppingCartPresenter(ViewManagerModel viewManagerModel,
                                 ShoppingCartViewModel shoppingCartViewModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessfulView(ShowShoppingCartOutputData showShoppingCartOutputData) {
        //TODO need to implement this
    }

}
