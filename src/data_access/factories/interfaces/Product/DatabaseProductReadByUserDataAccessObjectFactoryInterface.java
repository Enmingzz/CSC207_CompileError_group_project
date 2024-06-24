package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductReadByUserDataAccessInterface;
import entity.product.ProductFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    ProductReadByUserDataAccessInterface create(ProductFactory productFactory) throws SQLException;
}
