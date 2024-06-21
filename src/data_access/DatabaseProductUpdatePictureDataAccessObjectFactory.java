package data_access;

public class DatabaseProductUpdatePictureDataAccessObjectFactory implements DatabaseProductUpdatePictureDataAccessObjectFactoryInterface{
    @Override
    public ProductUpdatePictureDataAccessInterface create() {
        return new DatabaseProductUpdatePictureDataAccessObject();
    }
}
