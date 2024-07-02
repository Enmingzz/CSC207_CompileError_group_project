package data_access.factories.interfaces.ShoppingCart;

import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.ShoppingCartFactory;

import java.sql.SQLException;

public interface DatabaseShoppingCartReadDataAccessObjectFactoryInterface {

    ShoppingCartReadDataAccessInterface create(ShoppingCartFactory shoppingCartFactory,
                                               ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException;
}
