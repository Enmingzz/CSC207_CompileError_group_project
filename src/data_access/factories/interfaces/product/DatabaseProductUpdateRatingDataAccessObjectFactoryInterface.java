package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdateRatingDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateRatingDataAccessInterface.
 */
public interface DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateRatingDataAccessInterface.
     *
     * @return an instance of ProductUpdateRatingDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateRatingDataAccessInterface create() throws SQLException;
}
