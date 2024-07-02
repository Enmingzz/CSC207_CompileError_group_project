package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductUpdateAddressDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdateAddressDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateAddressDataAccessObjectFactory implements DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateAddressDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateAddressDataAccessObject();
    }
}
