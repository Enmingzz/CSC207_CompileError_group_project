package interface_adapter.schedule;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.schedule.BuyerSelectScheduleOutputBoundary;
import use_case.schedule.BuyerSelectScheduleOutputData;

import java.util.ArrayList;

public class BuyerSelectSchedulePresenter implements BuyerSelectScheduleOutputBoundary {
    private BuyerSelectScheduleViewModel viewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public BuyerSelectSchedulePresenter(BuyerSelectScheduleViewModel viewModel,
                                        ViewManagerModel viewManagerModel,
                                        ShoppingCartViewModel shoppingCartViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    @Override
    public void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData) {
        //move to shopping_cart_View
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
