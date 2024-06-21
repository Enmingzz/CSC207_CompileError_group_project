package data_access;

public class DatabaseProductReadByUserDataAccessObjectFactory implements DatabaseProductReadByUserDataAccessObjectFactoryInterface{

    @Override
    public ProductReadByUserDataAccessInterface create() {
        return new DatabaseProductReadByUserDataAccessObject();
    }
}
