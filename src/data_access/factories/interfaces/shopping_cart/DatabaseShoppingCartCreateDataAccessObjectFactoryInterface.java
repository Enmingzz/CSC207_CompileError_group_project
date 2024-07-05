package data_access.factories.interfaces.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {

    ShoppingCartCreateDataAccessInterface create() throws SQLException;
}
