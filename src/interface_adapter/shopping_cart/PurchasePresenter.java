package interface_adapter.shopping_cart;

import interface_adapter.ViewManagerModel;
import use_case.shopping_cart.PurchaseOutputData;
import use_case.shopping_cart.PurchaseOutputBoundary;
import data_access.interfaces.ShoppingCartReadDataAccessInterface;

import entity.shopping_cart.ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;

public class PurchasePresenter implements PurchaseOutputBoundary {

    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;
    private final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject;

    public PurchasePresenter(ShoppingCartViewModel shoppingCartViewModel, ViewManagerModel viewManagerModel,
                             ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartReadDataAccessObject = shoppingCartReadDataAccessObject;
    }

    @Override
    public void prepareSuccessView(PurchaseOutputData response) throws SQLException, IOException {
        // refreshes the view model of ShoppingCart
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        ShoppingCart shoppingCart = shoppingCartReadDataAccessObject.getShoppingCart(response.getUser().getStudentNumber());

        shoppingCartState.setListProducts(shoppingCart.getListProducts());

        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
