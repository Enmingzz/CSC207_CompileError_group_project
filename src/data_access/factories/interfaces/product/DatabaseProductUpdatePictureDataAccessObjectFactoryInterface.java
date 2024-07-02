package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {

    ProductUpdatePictureDataAccessInterface create() throws SQLException;
}
