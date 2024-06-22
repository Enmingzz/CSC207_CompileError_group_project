package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdatePictureDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {

    ProductUpdatePictureDataAccessInterface create() throws SQLException;
}
