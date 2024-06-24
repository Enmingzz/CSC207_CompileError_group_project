package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductCreateDataAccessInterface;

import java.sql.SQLException;

public interface DataBaseProductCreateDataAccessObjectFactoryInterface {
    ProductCreateDataAccessInterface create() throws SQLException;

}
