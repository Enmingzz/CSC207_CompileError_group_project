package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateDescriptionDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    ProductUpdateDescriptionDataAccessInterface create() throws SQLException;
}
