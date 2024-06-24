package app;

import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.view_product.BuyerViewProductView;

import java.sql.SQLException;

public class BuyerViewProductUseCaseFactory {

    public static BuyerViewProductView create(){
        //TODO need to implement this method
        return new BuyerViewProductView();
    }

    private static ShoppingCartController createShoppingCartController() throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter();
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }
}
