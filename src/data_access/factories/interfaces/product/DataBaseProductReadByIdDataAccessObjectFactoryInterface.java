package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DataBaseProductReadByIdDataAccessObjectFactoryInterface {
    ProductReadByIdDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
