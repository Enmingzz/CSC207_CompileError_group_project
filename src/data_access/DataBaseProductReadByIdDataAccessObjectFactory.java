package data_access;

public class DataBaseProductReadByIdDataAccessObjectFactory implements DataBaseProductReadByIdDataAccessObjectFactoryInterface{
    @Override
    public ProductReadByIdDataAccessInterface create() {
        return new DatabaseProductReadByIdDataAccessObject();
    }
}
