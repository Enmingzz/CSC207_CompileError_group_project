package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateTransferEmailDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {
    ProductUpdateTransferEmailDataAccessInterface create() throws SQLException;
}
