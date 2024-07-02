package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    ProductUpdateDescriptionDataAccessInterface create() throws SQLException;
}
