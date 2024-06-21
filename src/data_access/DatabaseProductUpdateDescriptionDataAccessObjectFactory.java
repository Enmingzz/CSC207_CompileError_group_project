package data_access;

public class DatabaseProductUpdateDescriptionDataAccessObjectFactory implements DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface{

    @Override
    public ProductUpdateDescriptionDataAccessInterface create() {
        return new DatabaseProductUpdateDescriptionDataAccessObject();
    }
}
