package data_access.factories.interfaces;

import data_access.interfaces.ShoppingCartCreateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {

    ShoppingCartCreateDataAccessInterface create() throws SQLException;
}
