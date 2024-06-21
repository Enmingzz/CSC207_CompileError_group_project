package data_access;

public class DataBaseProductCreateDataAccessObjectFactory implements DataBaseProductCreateDataAccessObjectFactoryInterface{
    public ProductCreateDataAccessInterface create(){
        return new DatabaseProductCreateDataAccessObject();
    }
}
