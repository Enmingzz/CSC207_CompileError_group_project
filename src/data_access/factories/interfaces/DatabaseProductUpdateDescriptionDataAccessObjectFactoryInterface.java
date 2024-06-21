package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdateDescriptionDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    ProductUpdateDescriptionDataAccessInterface create() throws SQLException;
}
