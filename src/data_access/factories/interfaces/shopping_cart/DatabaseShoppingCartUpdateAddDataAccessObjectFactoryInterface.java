package data_access.factories.interfaces.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface {

    ShoppingCartUpdateAddDataAccessInterface create() throws SQLException;
}
