package data_access.factories.objects.product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import data_access.factories.interfaces.product.DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface;
import data_access.objects.product.DatabaseProductUpdateDescriptionDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateDescriptionDataAccessObjectFactory implements DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    @Override
    public ProductUpdateDescriptionDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateDescriptionDataAccessObject();
    }
}
