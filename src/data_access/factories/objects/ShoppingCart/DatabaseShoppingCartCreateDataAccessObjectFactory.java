package data_access.factories.objects.ShoppingCart;

import data_access.interfaces.ShoppingCart.ShoppingCartCreateDataAccessInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.objects.ShoppingCart.DatabaseShoppingCartCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartCreateDataAccessObjectFactory implements DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {
    @Override
    public ShoppingCartCreateDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartCreateDataAccessObject();
    }
}
