package data_access.factories.objects.product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import data_access.factories.interfaces.product.DatabaseProductUpdateNameDataAccessObjectFactoryInterface;
import data_access.objects.product.DatabaseProductUpdateNameDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateNameDataAccessObjectFactory implements DatabaseProductUpdateNameDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateNameDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateNameDataAccessObject();
    }
}
