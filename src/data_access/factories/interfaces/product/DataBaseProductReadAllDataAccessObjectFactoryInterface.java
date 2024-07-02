package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DataBaseProductReadAllDataAccessObjectFactoryInterface {
    ProductReadAllDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
