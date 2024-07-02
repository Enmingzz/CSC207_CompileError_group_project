package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.shopping_cart.AddShoppingCartProductOutputData;
import use_case.shopping_cart.AddShoppingCartProductOutputBoundary;

public class AddToCartPresenter implements AddShoppingCartProductOutputBoundary{
    private final ShoppingCartViewModel shoppingCartViewModel;
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private ViewManagerModel viewManagerModel;

    public AddToCartPresenter(ViewManagerModel viewManagerModel,
                              ShoppingCartViewModel shoppingCartViewModel,
                              BuyerViewProductViewModel buyerViewProductViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.buyerViewProductViewModel = buyerViewProductViewModel;
    }

    @Override
    public void prepareSuccessView(AddShoppingCartProductOutputData response) {
        //move to shopping_cart_View
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setListProducts(response.getListProducts());
        shoppingCartState.setTotalPrice(response.getTotalPrice());

        //change the state in buyerViewProduct because View needs User's info
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        buyerViewProductState.setUser(response.getUser());

        this.shoppingCartViewModel.setState(shoppingCartState);
        this.buyerViewProductViewModel.setState(buyerViewProductState);

        shoppingCartViewModel.firePropertyChanged();
        buyerViewProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();



    }
}
