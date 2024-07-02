package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

import java.sql.SQLException;

public interface DataBaseProductCreateDataAccessObjectFactoryInterface {
    ProductCreateDataAccessInterface create() throws SQLException;

}
