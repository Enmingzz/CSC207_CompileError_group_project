package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

import java.sql.SQLException;

/**
 * DataBaseProductCreateDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductCreateDataAccessInterface.
 */
public interface DataBaseProductCreateDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductCreateDataAccessInterface.
     *
     * @return an instance of ProductCreateDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductCreateDataAccessInterface create() throws SQLException;
}
