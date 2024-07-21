package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartOutputData;
import java.util.ArrayList;
/**
 * Presenter for displaying the shopping cart, responsible for preparing the view model and triggering view updates.
 */
public class ShoppingCartPresenter implements ShowShoppingCartOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a {@link ShoppingCartPresenter} with the specified view models.
     *
     * @param viewManagerModel the view manager model to manage view changes
     * @param shoppingCartViewModel the view model for the shopping cart
     */
    public ShoppingCartPresenter(ViewManagerModel viewManagerModel,
                                 ShoppingCartViewModel shoppingCartViewModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    /**
     * Prepares the success view by updating the shopping cart state and triggering property changes.
     *
     * @param response the output data containing the shopping cart and user information
     */
    @Override
    public void prepareSuccessfulView(ShowShoppingCartOutputData response) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        ArrayList<Product> listProducts = response.getShoppingCart().getListProducts();
        User user = response.getUser();

        float totalPrice = 0;

        for (Product product : listProducts) {
            if (product.getState() != -1) {
                totalPrice += product.getPrice();
            }
        }

        shoppingCartState.setTotalPrice(totalPrice);

        System.out.println(shoppingCartState.getTotalPrice());

        shoppingCartState.setListProducts(listProducts);
        shoppingCartState.setUser(user);

        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        System.out.println("view shopping cart success and fire property changed");
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
