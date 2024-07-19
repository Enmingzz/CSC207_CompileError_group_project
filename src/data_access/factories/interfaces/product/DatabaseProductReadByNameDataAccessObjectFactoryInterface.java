package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

/**
 * DatabaseProductReadByNameDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductReadByNameDataAccessInterface.
 */
public interface DatabaseProductReadByNameDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductReadByNameDataAccessInterface.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @return an instance of ProductReadByNameDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductReadByNameDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
