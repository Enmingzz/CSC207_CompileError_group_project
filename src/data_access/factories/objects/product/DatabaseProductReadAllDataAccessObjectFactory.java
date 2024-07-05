package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.objects.product.DataBaseProductReadAllDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadAllDataAccessObjectFactory implements DataBaseProductReadAllDataAccessObjectFactoryInterface {
    @Override
    public ProductReadAllDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DataBaseProductReadAllDataAccessObject(productFactory, scheduleFactory);
    }
}
