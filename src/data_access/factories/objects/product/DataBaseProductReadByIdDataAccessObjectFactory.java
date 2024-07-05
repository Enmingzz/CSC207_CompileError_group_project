package data_access.factories.objects.product;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.factories.interfaces.product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.objects.product.DatabaseProductReadByIdDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DataBaseProductReadByIdDataAccessObjectFactory implements DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    @Override
    public ProductReadByIdDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByIdDataAccessObject(productFactory, scheduleFactory);
    }
}
