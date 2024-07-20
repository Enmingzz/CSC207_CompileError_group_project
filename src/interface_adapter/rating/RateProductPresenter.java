package interface_adapter.rating;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.rate_product.RateProductInputData;
import use_case.rate_product.RateProductOutputBoundary;
import use_case.rate_product.RateProductOutputData;
import view.ViewManager;

import java.util.ArrayList;
import java.util.Objects;

public class RateProductPresenter implements RateProductOutputBoundary {
    private final RateProductViewModel rateProductViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ShoppingCartViewModel shoppingCartViewModel;

    public RateProductPresenter(RateProductViewModel rateProductViewModel, ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) {
        this.rateProductViewModel = rateProductViewModel;
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    @Override
    public void prepareSuccessfulView(RateProductOutputData rateProductOutputData) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        ArrayList<Product> productList = shoppingCartState.getListProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID().equals(rateProductOutputData.getProduct().getProductID())) {
                productList.remove(productList.get(i));
            }
        }
        shoppingCartState.setListProducts(productList);
        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        //since we want to return to the shopping cart view, we need to call setActiveView
        viewManagerModel.setActiveView("shopping cart");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailedView(String error) {
        RateProductState rateProductState = rateProductViewModel.getState();
        rateProductState.setRatingError(error);
        rateProductViewModel.setState(rateProductState);
        rateProductViewModel.firePropertyChanged();
    }
}
