package interface_adapter;

import use_case.AddShoppingCartProductOutputData;
import use_case.AddShoppingCartProductOutputBoundary;

public class AddToCartPresenter implements AddShoppingCartProductOutputBoundary{
    private final AddToCartViewModel addToCartViewModel;
    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public AddToCartPresenter(ViewManagerModel viewManagerModel, AddToCartViewModel addToCartViewModel, ShoppingCartViewModel shoppingCartViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addToCartViewModel = addToCartViewModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    @Override
    public void prepareSuccessView(AddShoppingCartProductOutputData response{
        //move to shopping_cart_View

    }
}