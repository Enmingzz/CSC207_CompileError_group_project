package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdateTransferEmailDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {
    ProductUpdateTransferEmailDataAccessInterface create() throws SQLException;
}
