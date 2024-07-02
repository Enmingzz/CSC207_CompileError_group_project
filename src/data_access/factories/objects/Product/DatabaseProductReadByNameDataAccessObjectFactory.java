package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.objects.Product.DatabaseProductReadByNameDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadByNameDataAccessObjectFactory implements DatabaseProductReadByNameDataAccessObjectFactoryInterface {

    @Override
    public ProductReadByNameDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByNameDataAccessObject(productFactory, scheduleFactory);
    }
}
