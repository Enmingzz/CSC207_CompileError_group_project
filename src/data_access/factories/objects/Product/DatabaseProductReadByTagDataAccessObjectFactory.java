package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductReadByTagDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.Prouct.ProductReadByTagDataAccessInterface;
import data_access.objects.Product.DatabaseProductReadByNameDataAccessObject;
import data_access.objects.Product.DatabaseProductReadByTagDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public class DatabaseProductReadByTagDataAccessObjectFactory implements DatabaseProductReadByTagDataAccessObjectFactoryInterface {
    @Override
    public ProductReadByTagDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseProductReadByTagDataAccessObject(productFactory, scheduleFactory);
    }
}
