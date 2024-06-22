package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseProductUpdateRatingDataAccessObjectFactoryInterface;
import data_access.interfaces.ProductUpdateRatingDataAccessInterface;
import data_access.objects.DatabaseProductUpdateRatingDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateRatingDataAccessObjectFactory implements DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateRatingDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateRatingDataAccessObject();
    }
}
