package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    ProductReadByUserDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
