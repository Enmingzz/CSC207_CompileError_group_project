package interface_adapter.schedule;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.schedule.BuyerSelectScheduleOutputBoundary;
import use_case.schedule.BuyerSelectScheduleOutputData;

import java.util.ArrayList;

/**
 * The BuyerSelectSchedulePresenter class implements the BuyerSelectScheduleOutputBoundary interface
 * and handles the preparation of the view for the buyer select schedule use case.
 */
public class BuyerSelectSchedulePresenter implements BuyerSelectScheduleOutputBoundary {
    private BuyerSelectScheduleViewModel viewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a BuyerSelectSchedulePresenter with the specified view models and view manager model.
     *
     * @param viewModel the view model for the buyer select schedule
     * @param viewManagerModel the view manager model
     * @param shoppingCartViewModel the view model for the shopping cart
     */
    public BuyerSelectSchedulePresenter(BuyerSelectScheduleViewModel viewModel,
                                        ViewManagerModel viewManagerModel,
                                        ShoppingCartViewModel shoppingCartViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    /**
     * Prepares the successful view by updating the shopping cart with the selected schedule and switching the view
     * back to the shopping cart, with the given output data,
     *
     * @param outputData the output data containing the updated product
     */
    @Override
    public void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData) {
        //back to shopping_cart_View
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        ArrayList<Product> products = shoppingCartState.getListProducts();
        Product updated_product = outputData.getProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equals(updated_product.getProductID())) {
                products.set(i, updated_product);
            }
        }
        shoppingCartState.setListProducts(products);

        //change state error in buyerSchedule
        BuyerSelectScheduleState buyerSelectScheduleState = viewModel.getState();
        buyerSelectScheduleState.setError(null);

        this.viewModel.setState(buyerSelectScheduleState);
        this.shoppingCartViewModel.setState(shoppingCartState);
        viewModel.firePropertyChanged();
        shoppingCartViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailedView(String error) {
        BuyerSelectScheduleState buyerSelectScheduleState = viewModel.getState();
        buyerSelectScheduleState.setError(error);
        viewModel.setState(buyerSelectScheduleState);
        viewModel.firePropertyChanged();
    }
}
