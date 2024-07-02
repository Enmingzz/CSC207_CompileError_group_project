package data_access.factories.objects.Product;

import data_access.interfaces.Prouct.ProductReadByUserDataAccessInterface;
import data_access.factories.interfaces.Product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.objects.Product.DatabaseProductReadByUserDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadByUserDataAccessObjectFactory implements DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    @Override
    public ProductReadByUserDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByUserDataAccessObject(productFactory, scheduleFactory);
    }
}
