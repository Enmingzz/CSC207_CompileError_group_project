package interface_adapter;

import use_case.AddShoppingCartProductOutputData;
import use_case.AddShoppingCartProductOutputBoundary;

public class AddToCartPresenter implements AddShoppingCartProductOutputBoundary{
    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public AddToCartPresenter(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    @Override
    public void prepareSuccessView(AddShoppingCartProductOutputData response) {
        //move to shopping_cart_View
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setListProducts(response.getListProducts());
        this.shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
