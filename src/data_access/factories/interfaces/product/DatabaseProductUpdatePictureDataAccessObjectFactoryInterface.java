package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdatePictureDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdatePictureDataAccessInterface.
 */
public interface DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdatePictureDataAccessInterface.
     *
     * @return an instance of ProductUpdatePictureDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdatePictureDataAccessInterface create() throws SQLException;
}
