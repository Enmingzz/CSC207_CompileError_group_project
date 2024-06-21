package data_access.factories.objects;

import data_access.interfaces.ProductReadByUserDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductReadByUserDataAccessObject;
import entity.product.ProductFactory;

import java.sql.SQLException;

public class DatabaseProductReadByUserDataAccessObjectFactory implements DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    @Override
    public ProductReadByUserDataAccessInterface create(ProductFactory productFactory) throws SQLException {
        return new DatabaseProductReadByUserDataAccessObject(productFactory);
    }
}
