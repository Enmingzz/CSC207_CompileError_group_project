package data_access.factories.objects.shopping_cart;

import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.objects.shopping_cart.DatabaseShoppingCartUpdateDeleteDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory implements DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface {

    public ShoppingCartUpdateDeleteDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartUpdateDeleteDataAccessObject();
    }
}
