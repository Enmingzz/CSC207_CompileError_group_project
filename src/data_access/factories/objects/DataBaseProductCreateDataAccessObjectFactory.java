package data_access.factories.objects;

import data_access.interfaces.ProductCreateDataAccessInterface;
import data_access.factories.interfaces.DataBaseProductCreateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductCreateDataAccessObject;

import java.sql.SQLException;

public class DataBaseProductCreateDataAccessObjectFactory implements DataBaseProductCreateDataAccessObjectFactoryInterface {
    public ProductCreateDataAccessInterface create() throws SQLException {
        return new DatabaseProductCreateDataAccessObject();
    }
}
