package data_access.factories.objects.product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.objects.product.DatabaseProductReadByUserDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadByUserDataAccessObjectFactory implements DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    @Override
    public ProductReadByUserDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByUserDataAccessObject(productFactory, scheduleFactory);
    }
}
