package data_access.factories.objects;

import data_access.interfaces.ProductReadByIdDataAccessInterface;
import data_access.factories.interfaces.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductReadByIdDataAccessObject;

public class DataBaseProductReadByIdDataAccessObjectFactory implements DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    @Override
    public ProductReadByIdDataAccessInterface create() {
        return new DatabaseProductReadByIdDataAccessObject();
    }
}
