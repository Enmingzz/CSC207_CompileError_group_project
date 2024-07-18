package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

/**
 * DataBaseProductReadByIdDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductReadByIdDataAccessInterface.
 */
public interface DataBaseProductReadByIdDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductReadByIdDataAccessInterface.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @return an instance of ProductReadByIdDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductReadByIdDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
