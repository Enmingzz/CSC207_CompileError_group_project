package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdateRatingDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {
    ProductUpdateRatingDataAccessInterface create() throws SQLException;
}
