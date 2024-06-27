package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductReadAllDataAccessInterface;
import data_access.objects.Product.DataBaseProductReadAllDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadAllDataAccessObjectFactory implements DataBaseProductReadAllDataAccessObjectFactoryInterface {
    @Override
    public ProductReadAllDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DataBaseProductReadAllDataAccessObject(productFactory, scheduleFactory);
    }
}
