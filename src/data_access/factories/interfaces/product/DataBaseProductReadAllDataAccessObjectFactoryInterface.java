package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

/**
 * DataBaseProductReadAllDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductReadAllDataAccessInterface.
 */
public interface DataBaseProductReadAllDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductReadAllDataAccessInterface.
     *
     * @param productFactory a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @return an instance of ProductReadAllDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductReadAllDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
