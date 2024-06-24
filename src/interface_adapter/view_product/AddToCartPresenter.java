package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.shopping_cart.AddShoppingCartProductOutputData;
import use_case.shopping_cart.AddShoppingCartProductOutputBoundary;

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
        shoppingCartState.setTotalPrice(response.getTotalPrice());

        this.shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
