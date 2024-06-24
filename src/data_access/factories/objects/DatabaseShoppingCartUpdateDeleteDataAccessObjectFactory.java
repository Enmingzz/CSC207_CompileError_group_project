package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface;
import data_access.interfaces.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.objects.DatabaseShoppingCartUpdateDeleteDataAccessObject;

import java.sql.SQLException;

public class DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory implements DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface {

    public ShoppingCartUpdateDeleteDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartUpdateDeleteDataAccessObject();
    }
}
