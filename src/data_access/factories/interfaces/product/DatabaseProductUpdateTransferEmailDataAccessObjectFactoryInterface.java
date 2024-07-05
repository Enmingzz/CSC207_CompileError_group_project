package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {
    ProductUpdateTransferEmailDataAccessInterface create() throws SQLException;
}
