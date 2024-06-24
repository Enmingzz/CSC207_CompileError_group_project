package data_access.factories.interfaces.ShoppingCart;

import data_access.interfaces.ShoppingCart.ShoppingCartUpdateDeleteDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface {

    ShoppingCartUpdateDeleteDataAccessInterface create() throws SQLException;

}
