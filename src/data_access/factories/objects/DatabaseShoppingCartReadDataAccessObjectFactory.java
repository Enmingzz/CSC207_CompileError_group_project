package data_access.factories.objects;

import data_access.factories.interfaces.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.interfaces.ShoppingCartReadDataAccessInterface;
import data_access.objects.DatabaseShoppingCartReadDataAccessObject;
import entity.product.ProductFactory;
import entity.shopping_cart.ShoppingCartFactory;

import java.sql.SQLException;

public class DatabaseShoppingCartReadDataAccessObjectFactory implements DatabaseShoppingCartReadDataAccessObjectFactoryInterface {
    @Override
    public ShoppingCartReadDataAccessInterface create(ShoppingCartFactory shoppingCartFactory, ProductFactory productFactory) throws SQLException {
        return new DatabaseShoppingCartReadDataAccessObject(shoppingCartFactory, productFactory);
    }
}
