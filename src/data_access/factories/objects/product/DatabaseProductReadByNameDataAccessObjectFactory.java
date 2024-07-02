package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.objects.product.DatabaseProductReadByNameDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadByNameDataAccessObjectFactory implements DatabaseProductReadByNameDataAccessObjectFactoryInterface {

    @Override
    public ProductReadByNameDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByNameDataAccessObject(productFactory, scheduleFactory);
    }
}
