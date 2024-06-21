package data_access.factories.interfaces;

import data_access.interfaces.ProductCreateDataAccessInterface;

import java.sql.SQLException;

public interface DataBaseProductCreateDataAccessObjectFactoryInterface {
    ProductCreateDataAccessInterface create() throws SQLException;

}
