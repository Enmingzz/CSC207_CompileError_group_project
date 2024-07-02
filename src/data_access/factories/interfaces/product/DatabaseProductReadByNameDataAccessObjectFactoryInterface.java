package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByNameDataAccessObjectFactoryInterface {

    public ProductReadByNameDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
