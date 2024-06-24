package data_access.factories.interfaces.ShoppingCart;

import data_access.interfaces.ShoppingCart.ShoppingCartUpdateAddDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface {

    ShoppingCartUpdateAddDataAccessInterface create() throws SQLException;
}
