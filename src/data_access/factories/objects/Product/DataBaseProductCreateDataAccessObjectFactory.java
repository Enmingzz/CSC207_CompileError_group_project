package data_access.factories.objects.Product;

import data_access.interfaces.Prouct.ProductCreateDataAccessInterface;
import data_access.factories.interfaces.Product.DataBaseProductCreateDataAccessObjectFactoryInterface;
import data_access.objects.Product.DatabaseProductCreateDataAccessObject;

import java.sql.SQLException;

public class DataBaseProductCreateDataAccessObjectFactory implements DataBaseProductCreateDataAccessObjectFactoryInterface {
    public ProductCreateDataAccessInterface create() throws SQLException {
        return new DatabaseProductCreateDataAccessObject();
    }
}
