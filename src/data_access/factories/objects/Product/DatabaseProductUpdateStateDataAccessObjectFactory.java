package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdateStateDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateStateDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateStateDataAccessObjectFactory implements DatabaseProductUpdateStateDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateStateDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateStateDataAccessObject();
    }
}
