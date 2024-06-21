package data_access.factories.objects;

import data_access.interfaces.ProductCreateDataAccessInterface;
import data_access.factories.interfaces.DataBaseProductCreateDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseProductCreateDataAccessObject;

public class DataBaseProductCreateDataAccessObjectFactory implements DataBaseProductCreateDataAccessObjectFactoryInterface {
    public ProductCreateDataAccessInterface create(){
        return new DatabaseProductCreateDataAccessObject();
    }
}
