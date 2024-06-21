package data_access.factories.objects;

import data_access.interfaces.ProductUpdateNameDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductUpdateNameDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductUpdateNameDataAccessObject;

public class DatabaseProductUpdateNameDataAccessObjectFactory implements DatabaseProductUpdateNameDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateNameDataAccessInterface create() {
        return new DatabaseProductUpdateNameDataAccessObject();
    }
}
