package data_access.factories.objects.Product;

import data_access.interfaces.Prouct.ProductReadByIdDataAccessInterface;
import data_access.factories.interfaces.Product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.objects.Product.DatabaseProductReadByIdDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DataBaseProductReadByIdDataAccessObjectFactory implements DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    @Override
    public ProductReadByIdDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByIdDataAccessObject(productFactory, scheduleFactory);
    }
}
