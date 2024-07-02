package data_access.factories.objects.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.objects.shopping_cart.DatabaseShoppingCartCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartCreateDataAccessObjectFactory implements DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {
    @Override
    public ShoppingCartCreateDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartCreateDataAccessObject();
    }
}
