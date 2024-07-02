package data_access.factories.interfaces.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface {

    ShoppingCartUpdateDeleteDataAccessInterface create() throws SQLException;

}
