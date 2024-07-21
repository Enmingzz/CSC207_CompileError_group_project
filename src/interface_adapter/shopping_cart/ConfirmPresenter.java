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
/**
 * Presenter for confirming an action in the shopping cart, responsible for preparing the view model and triggering view updates.
 */
public class ConfirmPresenter implements ConfirmOutputBoundary {

    private final RateProductViewModel rateProductViewModel;
    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a {@link ConfirmPresenter} with the specified view models and view manager model.
     *
     * @param rateProductViewModel the view model for rating a product
     * @param shoppingCartViewModel the view model for the shopping cart
     * @param viewManagerModel the view manager model to manage view changes
     */
    public ConfirmPresenter(RateProductViewModel rateProductViewModel,
                            ShoppingCartViewModel shoppingCartViewModel,
                            ViewManagerModel viewManagerModel) {
        this.rateProductViewModel = rateProductViewModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    /**
     * Prepares the success view by updating the rate product state and the shopping cart state,
     * and triggering property changes.
     *
     * @param response the output data containing the confirmed product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void prepareSuccessView(ConfirmOutputData response) throws SQLException, IOException {
        RateProductState rateProductState = rateProductViewModel.getState();
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();

        Product confirmedProduct = response.getProduct();
        String confirmedProductId = confirmedProduct.getProductID();

        ArrayList<Product> listProducts = shoppingCartState.getListProducts();
        ArrayList<Product> newListProducts = new ArrayList<>();

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
