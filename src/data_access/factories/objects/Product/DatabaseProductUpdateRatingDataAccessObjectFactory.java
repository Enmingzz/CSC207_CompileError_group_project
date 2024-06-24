package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductUpdateRatingDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdateRatingDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateRatingDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateRatingDataAccessObjectFactory implements DatabaseProductUpdateRatingDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateRatingDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateRatingDataAccessObject();
    }
}
