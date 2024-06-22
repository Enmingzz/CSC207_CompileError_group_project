package data_access.factories.objects;

import data_access.interfaces.ProductUpdatePictureDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductUpdatePictureDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductUpdatePictureDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdatePictureDataAccessObjectFactory implements DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdatePictureDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdatePictureDataAccessObject();
    }
}
