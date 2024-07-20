package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartOutputData;
import java.util.ArrayList;

public class ShoppingCartPresenter implements ShowShoppingCartOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShoppingCartPresenter(ViewManagerModel viewManagerModel,
                                 ShoppingCartViewModel shoppingCartViewModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(ShowShoppingCartOutputData response) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        ArrayList<Product> listProducts = response.getShoppingCart().getListProducts();
        User user = response.getUser();

        float totalPrice = 0;

        for (Product product : listProducts) {
            totalPrice += product.getPrice();
        }

        shoppingCartState.setTotalPrice(totalPrice);

        System.out.println(shoppingCartState.getTotalPrice());

        shoppingCartState.setListProducts(listProducts);
        shoppingCartState.setUser(user);

        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
