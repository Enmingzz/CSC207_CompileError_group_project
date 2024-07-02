package data_access.factories.objects.ShoppingCart;

import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObject;
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
