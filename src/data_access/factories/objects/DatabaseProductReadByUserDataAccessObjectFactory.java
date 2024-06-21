package data_access.factories.objects;

import data_access.interfaces.ProductReadByUserDataAccessInterface;
import data_access.factories.interfaces.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductReadByUserDataAccessObject;

public class DatabaseProductReadByUserDataAccessObjectFactory implements DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    @Override
    public ProductReadByUserDataAccessInterface create() {
        return new DatabaseProductReadByUserDataAccessObject();
    }
}
