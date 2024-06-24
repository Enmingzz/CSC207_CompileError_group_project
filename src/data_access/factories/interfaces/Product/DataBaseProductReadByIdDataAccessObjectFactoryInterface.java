package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductReadByIdDataAccessInterface;
import entity.product.ProductFactory;

import java.sql.SQLException;

public interface DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    ProductReadByIdDataAccessInterface create(ProductFactory productFactory) throws SQLException;
}
