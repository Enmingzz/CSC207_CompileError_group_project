package data_access.factories.objects.product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import data_access.factories.interfaces.product.DatabaseProductUpdatePictureDataAccessObjectFactoryInterface;
import data_access.objects.product.DatabaseProductUpdatePictureDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdatePictureDataAccessObjectFactory implements DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdatePictureDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdatePictureDataAccessObject();
    }
}
