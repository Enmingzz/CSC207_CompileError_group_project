package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseProductUpdateAddressDataAccessObjectFactoryInterface;
import data_access.interfaces.ProductUpdateAddressDataAccessInterface;
import data_access.objects.DatabaseProductUpdateAddressDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateAddressDataAccessObjectFactory implements DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateAddressDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateAddressDataAccessObject();
    }
}
