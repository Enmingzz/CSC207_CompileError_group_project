package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;

import java.sql.SQLException;

public interface DataBaseProductDeleteByIDDataAccessObjectFactoryInterface {
    ProductDeleteDataAccessByIDInterface create() throws SQLException;
}
