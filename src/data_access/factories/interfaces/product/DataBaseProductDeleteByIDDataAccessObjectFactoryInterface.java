package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;

import java.sql.SQLException;

/**
 * DataBaseProductDeleteByIDDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductDeleteDataAccessByIDInterface.
 */
public interface DataBaseProductDeleteByIDDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductDeleteDataAccessByIDInterface.
     *
     * @return an instance of ProductDeleteDataAccessByIDInterface
     * @throws SQLException if a database access error occurs
     */
    ProductDeleteDataAccessByIDInterface create() throws SQLException;
}
