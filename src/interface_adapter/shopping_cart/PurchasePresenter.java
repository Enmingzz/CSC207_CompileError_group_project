package interface_adapter.shopping_cart;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.PurchaseOutputData;
import use_case.shopping_cart.PurchaseOutputBoundary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Presenter for purchasing a product from the shopping cart, responsible for preparing the view model and triggering view updates.
 */
public class PurchasePresenter implements PurchaseOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;
    /**
     * Constructs a {@link PurchasePresenter} with the specified view models.
     *
     * @param shoppingCartViewModel the view model for the shopping cart
     * @param viewManagerModel the view manager model to manage view changes
     */
    public PurchasePresenter(ShoppingCartViewModel shoppingCartViewModel, ViewManagerModel viewManagerModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    /**
     * Prepares the success view by updating the shopping cart state and triggering property changes.
     *
     * @param response the output data containing the purchased product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
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
