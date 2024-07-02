package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartOutputData;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPresenter implements ShowShoppingCartOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShoppingCartPresenter(ViewManagerModel viewManagerModel,
                                 ShoppingCartViewModel shoppingCartViewModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(ShowShoppingCartOutputData response) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        List<Product> listProducts = response.getShoppingCart().getListProducts();
        User user = response.getUser();

        shoppingCartState.setListProducts(listProducts);
        shoppingCartState.setUser(user);

        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
