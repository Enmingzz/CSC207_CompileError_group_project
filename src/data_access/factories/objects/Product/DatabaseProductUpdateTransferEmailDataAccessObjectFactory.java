package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdateTransferEmailDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateTransferEmailDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateTransferEmailDataAccessObjectFactory implements DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateTransferEmailDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateTransferEmailDataAccessObject();
    }
}
