package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductUpdateAddressDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdateAddressDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateAddressDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateAddressDataAccessObjectFactory implements DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateAddressDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateAddressDataAccessObject();
    }
}
