package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface;
import data_access.interfaces.ShoppingCartUpdateAddDataAccessInterface;
import data_access.objects.DatabaseShoppingCartUpdateAddDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartUpdateAddDataAccessObjectFactory implements DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface {


    @Override
    public ShoppingCartUpdateAddDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartUpdateAddDataAccessObject();
    }
}
