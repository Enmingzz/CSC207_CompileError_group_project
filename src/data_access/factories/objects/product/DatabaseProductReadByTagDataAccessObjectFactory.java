package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductReadByTagDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import data_access.objects.product.DatabaseProductReadByTagDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadByTagDataAccessObjectFactory implements DatabaseProductReadByTagDataAccessObjectFactoryInterface {
    @Override
    public ProductReadByTagDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByTagDataAccessObject(productFactory, scheduleFactory);
    }
}
