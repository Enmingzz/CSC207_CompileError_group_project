package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdateTransferEmailDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateTransferEmailDataAccessObjectFactory implements DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateTransferEmailDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateTransferEmailDataAccessObject();
    }
}
