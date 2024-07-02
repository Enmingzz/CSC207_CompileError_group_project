package data_access.factories.interfaces.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.ShoppingCartFactory;

import java.sql.SQLException;

public interface DatabaseShoppingCartReadDataAccessObjectFactoryInterface {

    ShoppingCartReadDataAccessInterface create(ShoppingCartFactory shoppingCartFactory,
                                               ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
