package interface_adapter.rating;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.rate_product.RateProductOutputBoundary;
import use_case.rate_product.RateProductOutputData;

import java.util.ArrayList;

/**
 * Presenter class for handling the output of the rate product use case.
 * It updates the view models and manages the state based on the output data.
 */
public class RateProductPresenter implements RateProductOutputBoundary {
    private final RateProductViewModel rateProductViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ShoppingCartViewModel shoppingCartViewModel;

    /**
     * Constructs a RateProductPresenter with the specified view models.
     *
     * @param rateProductViewModel   The view model for rating products.
     * @param viewManagerModel       The view manager model.
     * @param shoppingCartViewModel  The view model for the shopping cart.
     */
    public RateProductPresenter(RateProductViewModel rateProductViewModel, ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) {
        this.rateProductViewModel = rateProductViewModel;
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    /**
     * Prepares the successful view after a product is rated.
     *
     * @param rateProductOutputData The output data after rating a product.
     */
    @Override
    public void prepareSuccessfulView(RateProductOutputData rateProductOutputData) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        float totalPrice = shoppingCartState.getTotalPrice();
        ArrayList<Product> productList = shoppingCartState.getListProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID().equals(rateProductOutputData.getProduct().getProductID())) {
                totalPrice -= productList.get(i).getPrice();
                productList.remove(productList.get(i));
            }
        }
        shoppingCartState.setListProducts(productList);
        shoppingCartState.setTotalPrice(totalPrice);
        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        // Since we want to return to the shopping cart view, we need to call setActiveView
        viewManagerModel.setActiveView("shopping cart");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failed view if rating a product fails.
     *
     * @param error The error message indicating why the rating failed.
     */
    @Override
    public void prepareFailedView(String error) {
        RateProductState rateProductState = rateProductViewModel.getState();
        rateProductState.setRatingError(error);
        rateProductViewModel.setState(rateProductState);
        rateProductViewModel.firePropertyChanged();
    }
}
