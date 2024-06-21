package data_access.factories.interfaces;

import data_access.interfaces.ShoppingCartReadDataAccessInterface;
import entity.shopping_cart.ShoppingCartFactory;

import java.sql.SQLException;

public interface DatabaseShoppingCartReadDataAccessObjectFactoryInterface {

    ShoppingCartReadDataAccessInterface create(ShoppingCartFactory shoppingCartFactory) throws SQLException;
}
