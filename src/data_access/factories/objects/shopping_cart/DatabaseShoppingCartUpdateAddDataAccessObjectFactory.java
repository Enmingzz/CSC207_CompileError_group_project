package data_access.factories.objects.shopping_cart;

import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import data_access.objects.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartUpdateAddDataAccessObjectFactory implements DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface {


    @Override
    public ShoppingCartUpdateAddDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartUpdateAddDataAccessObject();
    }
}
