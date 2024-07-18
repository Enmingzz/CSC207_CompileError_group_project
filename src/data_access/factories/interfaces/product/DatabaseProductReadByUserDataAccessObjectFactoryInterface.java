package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

/**
 * DatabaseProductReadByUserDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductReadByUserDataAccessInterface.
 */
public interface DatabaseProductReadByUserDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductReadByUserDataAccessInterface.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @return an instance of ProductReadByUserDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductReadByUserDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
