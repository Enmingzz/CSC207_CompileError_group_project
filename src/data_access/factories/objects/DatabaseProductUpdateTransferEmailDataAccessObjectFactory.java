package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface;
import data_access.interfaces.ProductUpdateTransferEmailDataAccessInterface;
import data_access.objects.DatabaseProductUpdateTransferEmailDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateTransferEmailDataAccessObjectFactory implements DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateTransferEmailDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateTransferEmailDataAccessObject();
    }
}
