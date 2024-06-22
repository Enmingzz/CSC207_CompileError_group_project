package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.interfaces.ProductUpdateStateDataAccessInterface;
import data_access.objects.DatabaseProductUpdateStateDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateStateDataAccessObjectFactory implements DatabaseProductUpdateStateDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateStateDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateStateDataAccessObject();
    }
}
