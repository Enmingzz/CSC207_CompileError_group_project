package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductUpdatePriceDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdatePriceDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdatePriceDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdatePriceDataAccessObjectFactory implements DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {

    @Override
    public ProductUpdatePriceDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdatePriceDataAccessObject();
    }
}
