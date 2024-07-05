package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByTagDataAccessObjectFactoryInterface {
    ProductReadByTagDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
