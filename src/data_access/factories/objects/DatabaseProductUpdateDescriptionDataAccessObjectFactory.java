package data_access.factories.objects;

import data_access.interfaces.ProductUpdateDescriptionDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductUpdateDescriptionDataAccessObject;

public class DatabaseProductUpdateDescriptionDataAccessObjectFactory implements DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface {

    @Override
    public ProductUpdateDescriptionDataAccessInterface create() {
        return new DatabaseProductUpdateDescriptionDataAccessObject();
    }
}
