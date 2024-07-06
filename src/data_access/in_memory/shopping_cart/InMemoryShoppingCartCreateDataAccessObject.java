package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryShoppingCartCreateDataAccessObject implements ShoppingCartCreateDataAccessInterface {

    @Override
    public void saveShoppingCart(User user) throws SQLException {

    }
}
