package data_access.factories.objects;

import data_access.interfaces.ShoppingCartCreateDataAccessInterface;
import data_access.factories.interfaces.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseShoppingCartCreateDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartCreateDataAccessObjectFactory implements DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {
    @Override
    public ShoppingCartCreateDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartCreateDataAccessObject();
    }
}
