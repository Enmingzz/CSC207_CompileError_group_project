package data_access.factories.objects.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import data_access.factories.interfaces.product.DataBaseProductCreateDataAccessObjectFactoryInterface;
import data_access.objects.product.DatabaseProductCreateDataAccessObject;

import java.sql.SQLException;

public class DataBaseProductCreateDataAccessObjectFactory implements DataBaseProductCreateDataAccessObjectFactoryInterface {
    public ProductCreateDataAccessInterface create() throws SQLException {
        return new DatabaseProductCreateDataAccessObject();
    }
}
