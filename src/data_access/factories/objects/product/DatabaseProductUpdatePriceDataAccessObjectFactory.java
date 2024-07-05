package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductUpdatePriceDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdatePriceDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdatePriceDataAccessObjectFactory implements DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {

    @Override
    public ProductUpdatePriceDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdatePriceDataAccessObject();
    }
}
