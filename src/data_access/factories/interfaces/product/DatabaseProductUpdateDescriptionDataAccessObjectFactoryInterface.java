package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateDescriptionDataAccessInterface.
 */
public interface DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateDescriptionDataAccessInterface.
     *
     * @return an instance of ProductUpdateDescriptionDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateDescriptionDataAccessInterface create() throws SQLException;
}
