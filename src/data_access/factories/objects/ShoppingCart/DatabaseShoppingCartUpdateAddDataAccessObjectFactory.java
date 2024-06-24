package data_access.factories.objects.ShoppingCart;

import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartUpdateAddDataAccessInterface;
import data_access.objects.ShoppingCart.DatabaseShoppingCartUpdateAddDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartUpdateAddDataAccessObjectFactory implements DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface {


    @Override
    public ShoppingCartUpdateAddDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartUpdateAddDataAccessObject();
    }
}
