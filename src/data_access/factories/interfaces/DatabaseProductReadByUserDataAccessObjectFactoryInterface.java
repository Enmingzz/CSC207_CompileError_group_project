package data_access.factories.interfaces;

import data_access.interfaces.ProductReadByUserDataAccessInterface;
import entity.product.ProductFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    ProductReadByUserDataAccessInterface create(ProductFactory productFactory) throws SQLException;
}
