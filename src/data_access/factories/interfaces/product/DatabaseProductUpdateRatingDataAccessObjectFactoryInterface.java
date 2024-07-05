package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {
    ProductUpdateRatingDataAccessInterface create() throws SQLException;
}
