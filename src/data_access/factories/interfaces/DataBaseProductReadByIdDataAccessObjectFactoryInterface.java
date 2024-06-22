package data_access.factories.interfaces;

import data_access.interfaces.ProductReadByIdDataAccessInterface;
import entity.product.ProductFactory;

import java.sql.SQLException;

public interface DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    ProductReadByIdDataAccessInterface create(ProductFactory productFactory) throws SQLException;
}
