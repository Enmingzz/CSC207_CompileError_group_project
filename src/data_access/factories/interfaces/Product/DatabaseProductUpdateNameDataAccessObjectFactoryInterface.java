package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateNameDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateNameDataAccessObjectFactoryInterface {

    ProductUpdateNameDataAccessInterface create() throws SQLException;
}
