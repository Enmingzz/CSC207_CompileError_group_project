package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseProductUpdatePriceDataAccessObjectFactoryInterface;
import data_access.interfaces.ProductUpdatePriceDataAccessInterface;
import data_access.objects.DatabaseProductUpdatePriceDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdatePriceDataAccessObjectFactory implements DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {

    @Override
    public ProductUpdatePriceDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdatePriceDataAccessObject();
    }
}
