package data_access.factories.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateNameDataAccessInterface;
import data_access.factories.interfaces.Product.DatabaseProductUpdateNameDataAccessObjectFactoryInterface;
import data_access.objects.Product.DatabaseProductUpdateNameDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateNameDataAccessObjectFactory implements DatabaseProductUpdateNameDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateNameDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateNameDataAccessObject();
    }
}
