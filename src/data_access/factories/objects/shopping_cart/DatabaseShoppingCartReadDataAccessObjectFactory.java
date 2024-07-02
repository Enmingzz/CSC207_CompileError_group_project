package data_access.factories.objects.shopping_cart;

import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObject;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.ShoppingCartFactory;

import java.sql.SQLException;

public class DatabaseShoppingCartReadDataAccessObjectFactory implements DatabaseShoppingCartReadDataAccessObjectFactoryInterface {
    @Override
    public ShoppingCartReadDataAccessInterface create(ShoppingCartFactory shoppingCartFactory,
                                                      ProductFactory productFactory,
                                                      ScheduleFactory scheduleFactory) throws SQLException {
        return new DatabaseShoppingCartReadDataAccessObject(shoppingCartFactory, productFactory,
                scheduleFactory);
    }
}
