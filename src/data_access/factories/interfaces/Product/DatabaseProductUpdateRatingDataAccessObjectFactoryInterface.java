package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateRatingDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {
    ProductUpdateRatingDataAccessInterface create() throws SQLException;
}
