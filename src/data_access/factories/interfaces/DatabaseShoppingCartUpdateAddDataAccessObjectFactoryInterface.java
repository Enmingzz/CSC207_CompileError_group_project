package data_access.factories.interfaces;

import data_access.interfaces.ShoppingCartUpdateAddDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface {

    ShoppingCartUpdateAddDataAccessInterface create() throws SQLException;
}
