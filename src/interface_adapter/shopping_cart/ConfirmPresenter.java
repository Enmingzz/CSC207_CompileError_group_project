package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.ConfirmOutputBoundary;
import use_case.shopping_cart.ConfirmOutputData;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.rating.RateProductState;
import interface_adapter.ViewManagerModel;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.sql.SQLException;

public class ConfirmPresenter implements ConfirmOutputBoundary {

    private final RateProductViewModel rateProductViewModel;
    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public ConfirmPresenter(RateProductViewModel rateProductViewModel,
                            ShoppingCartViewModel shoppingCartViewModel,
                            ViewManagerModel viewManagerModel) {
        this.rateProductViewModel = rateProductViewModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ConfirmOutputData response) throws SQLException, IOException {
        RateProductState rateProductState = rateProductViewModel.getState();
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();

        Product confirmedProduct = response.getProduct();
        String confirmedProductId = confirmedProduct.getProductID();

        List<Product> listProducts = shoppingCartState.getListProducts();
        List<Product> newListProducts = new ArrayList<>();

        for (Product product: listProducts) {
            if (product.getProductID().equals(confirmedProductId)) {
                newListProducts.add(confirmedProduct);
            }
            else{
                newListProducts.add(product);
            }
        }

        shoppingCartState.setListProducts(newListProducts);

        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();

        rateProductState.setProduct(confirmedProduct);

        rateProductViewModel.setState(rateProductState);
        rateProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(rateProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
