package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductReadByUserDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    ProductReadByUserDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
