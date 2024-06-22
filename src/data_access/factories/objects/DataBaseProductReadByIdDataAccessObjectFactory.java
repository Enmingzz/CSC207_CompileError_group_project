package data_access.factories.objects;

import data_access.interfaces.ProductReadByIdDataAccessInterface;
import data_access.factories.interfaces.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductReadByIdDataAccessObject;
import entity.product.ProductFactory;

import java.sql.SQLException;

public class DataBaseProductReadByIdDataAccessObjectFactory implements DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    @Override
    public ProductReadByIdDataAccessInterface create(ProductFactory productFactory) throws SQLException {
        return new DatabaseProductReadByIdDataAccessObject(productFactory);
    }
}
