package data_access;

public class DatabaseProductUpdateNameDataAccessObjectFactory implements DatabaseProductUpdateNameDataAccessObjectFactoryInterface{
    @Override
    public ProductUpdateNameDataAccessInterface create() {
        return new DatabaseProductUpdateNameDataAccessObject();
    }
}
