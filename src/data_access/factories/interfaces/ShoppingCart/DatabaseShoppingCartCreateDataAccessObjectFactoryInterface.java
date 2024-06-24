package data_access.factories.interfaces.ShoppingCart;

import data_access.interfaces.ShoppingCart.ShoppingCartCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {

    ShoppingCartCreateDataAccessInterface create() throws SQLException;
}
