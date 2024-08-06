package interface_adapter.view_product.add_to_cart;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.view_product.buyer_view.BuyerViewProductState;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import use_case.shopping_cart.AddShoppingCartProductOutputData;
import use_case.shopping_cart.AddShoppingCartProductOutputBoundary;

/**
 * The AddToCartPresenter class implements the AddShoppingCartProductOutputBoundary
 * and handles the presentation logic for adding a product to the shopping cart.
 */
public class AddToCartPresenter implements AddShoppingCartProductOutputBoundary {
    private final ShoppingCartViewModel shoppingCartViewModel;
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs an AddToCartPresenter with the specified view models and view manager model.
     *
     * @param viewManagerModel the view manager model to manage active views.
     * @param shoppingCartViewModel the view model for the shopping cart.
     * @param buyerViewProductViewModel the view model for the buyer view product.
     */
    public AddToCartPresenter(ViewManagerModel viewManagerModel,
                              ShoppingCartViewModel shoppingCartViewModel,
                              BuyerViewProductViewModel buyerViewProductViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.buyerViewProductViewModel = buyerViewProductViewModel;
    }

    /**
     * Prepares the success view for adding a product to the shopping cart.
     *
     * @param response the output data containing the result of adding a product to the shopping cart.
     */
    @Override
    public void prepareSuccessView(AddShoppingCartProductOutputData response) {
        // Update the shopping cart state
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setListProducts(response.getListProducts());

        float totalPrice = 0;

        for (Product product : shoppingCartState.getListProducts()) {
            if (product.getState() != -1) {
                totalPrice += product.getPrice();
            }
        }

        shoppingCartState.setTotalPrice(totalPrice);
        shoppingCartState.setErrorMessage(response.getErrorMessage());
        shoppingCartState.setUser(response.getUser());

        // Update the buyer view product state
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        buyerViewProductState.setUser(response.getUser());

        // Set the updated states
        this.shoppingCartViewModel.setState(shoppingCartState);
        this.buyerViewProductViewModel.setState(buyerViewProductState);

        // Notify the views of the state changes
        shoppingCartViewModel.firePropertyChanged();
        buyerViewProductViewModel.firePropertyChanged();

        // Set the active view to the shopping cart view
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failed view with the specified error message.
     *
     * @param errorMessage the error message to be displayed.
     */
    @Override
    public void prepareFailedView(String errorMessage) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setErrorMessage(errorMessage);
        shoppingCartViewModel.firePropertyChanged();
        shoppingCartState.setErrorMessage("");
    }
}
