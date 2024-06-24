package data_access.factories.objects.ShoppingCart;

import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.objects.ShoppingCart.DatabaseShoppingCartUpdateDeleteDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory implements DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface {

    public ShoppingCartUpdateDeleteDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartUpdateDeleteDataAccessObject();
    }
}
