package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.Prouct.ProductReadByTagDataAccessInterface;
import data_access.objects.Product.DatabaseProductReadByNameDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;

public interface DatabaseProductReadByTagDataAccessObjectFactoryInterface {

    public ProductReadByTagDataAccessInterface create(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
