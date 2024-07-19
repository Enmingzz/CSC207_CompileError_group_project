package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

/**
 * DatabaseProductReadByTagDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductReadByTagDataAccessInterface.
 */
public interface DatabaseProductReadByTagDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductReadByTagDataAccessInterface.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @return an instance of ProductReadByTagDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductReadByTagDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
