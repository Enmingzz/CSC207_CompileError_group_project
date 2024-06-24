package data_access.factories.objects.Product;

import data_access.interfaces.Prouct.ProductUpdatePictureDataAccessInterface;
import data_access.factories.interfaces.Product.DatabaseProductUpdatePictureDataAccessObjectFactoryInterface;
import data_access.objects.Product.DatabaseProductUpdatePictureDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdatePictureDataAccessObjectFactory implements DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdatePictureDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdatePictureDataAccessObject();
    }
}
