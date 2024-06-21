package data_access.factories.objects;

import data_access.interfaces.ProductUpdatePictureDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductUpdatePictureDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductUpdatePictureDataAccessObject;

public class DatabaseProductUpdatePictureDataAccessObjectFactory implements DatabaseProductUpdatePictureDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdatePictureDataAccessInterface create() {
        return new DatabaseProductUpdatePictureDataAccessObject();
    }
}
