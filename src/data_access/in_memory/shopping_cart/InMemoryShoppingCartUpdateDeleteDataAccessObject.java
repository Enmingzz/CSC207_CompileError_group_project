package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {


    @Override
    public void updateShoppingCart(User user, Product product) throws SQLException {

    }
}
