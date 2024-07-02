package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdateStateDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateStateDataAccessObjectFactory implements DatabaseProductUpdateStateDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateStateDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateStateDataAccessObject();
    }
}
