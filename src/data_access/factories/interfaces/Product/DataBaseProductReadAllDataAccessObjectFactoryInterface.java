package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductReadAllDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DataBaseProductReadAllDataAccessObjectFactoryInterface {
    ProductReadAllDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
