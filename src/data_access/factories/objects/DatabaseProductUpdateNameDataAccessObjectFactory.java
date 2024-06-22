package data_access.factories.objects;

import data_access.interfaces.ProductUpdateNameDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductUpdateNameDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductUpdateNameDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateNameDataAccessObjectFactory implements DatabaseProductUpdateNameDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateNameDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateNameDataAccessObject();
    }
}
