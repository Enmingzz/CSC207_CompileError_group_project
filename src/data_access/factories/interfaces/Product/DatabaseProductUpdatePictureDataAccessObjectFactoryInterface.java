package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdatePictureDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {

    ProductUpdatePictureDataAccessInterface create() throws SQLException;
}
