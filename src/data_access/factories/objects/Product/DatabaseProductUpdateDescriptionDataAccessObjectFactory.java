package data_access.factories.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateDescriptionDataAccessInterface;
import data_access.factories.interfaces.Product.DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface;
import data_access.objects.Product.DatabaseProductUpdateDescriptionDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateDescriptionDataAccessObjectFactory implements DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    @Override
    public ProductUpdateDescriptionDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateDescriptionDataAccessObject();
    }
}
