package interface_adapter.shopping_cart;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.PurchaseOutputData;
import use_case.shopping_cart.PurchaseOutputBoundary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchasePresenter implements PurchaseOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public PurchasePresenter(ShoppingCartViewModel shoppingCartViewModel, ViewManagerModel viewManagerModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(PurchaseOutputData response) throws SQLException, IOException {
        // refreshes the view model of shopping_cart
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        Product purchasedProduct = response.getProduct();
        String purchasedProductId = purchasedProduct.getProductID();

        ArrayList<Product> listProducts = shoppingCartState.getListProducts();
        ArrayList<Product> newListProducts = new ArrayList<>();

        for (Product product: listProducts) {
            if (product.getProductID().equals(purchasedProductId)) {
                newListProducts.add(purchasedProduct);
            }
            else{
                newListProducts.add(product);
            }
        }

        shoppingCartState.setListProducts(newListProducts);

        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
