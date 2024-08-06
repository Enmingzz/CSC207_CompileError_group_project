package interface_adapter.shopping_cart.delete;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import use_case.shopping_cart.DeleteShoppingCartProductOutputBoundary;
import use_case.shopping_cart.DeleteShoppingCartProductOutputData;

/**
 * Presenter for deleting a product from the shopping cart, responsible for preparing the view model and triggering view updates.
 */
public class DeleteShoppingCartProductPresenter implements DeleteShoppingCartProductOutputBoundary {
    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a {@link DeleteShoppingCartProductPresenter} with the specified view models.
     *
     * @param shoppingCartViewModel the view model for the shopping cart
     * @param viewManagerModel the view manager model to manage view changes
     */
    public DeleteShoppingCartProductPresenter(ShoppingCartViewModel shoppingCartViewModel,
                                              ViewManagerModel viewManagerModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view by updating the shopping cart state and triggering property changes.
     *
     * @param response the output data containing the updated list of products and total price
     */
    public void prepareSuccessView(DeleteShoppingCartProductOutputData response) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setListProducts(response.getListProducts());

        float totalPrice = 0;

        for (Product product : shoppingCartState.getListProducts()) {
            if (product.getState() != -1) {
                totalPrice += product.getPrice();
            }
        }

        totalPrice -= response.getTotalPrice();

        shoppingCartState.setTotalPrice(totalPrice);

        this.shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
