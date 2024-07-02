package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductUpdateRatingDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdateRatingDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateRatingDataAccessObjectFactory implements DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateRatingDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateRatingDataAccessObject();
    }
}
