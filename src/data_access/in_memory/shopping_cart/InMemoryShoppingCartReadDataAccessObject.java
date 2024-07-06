package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.shopping_cart.ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;

public class InMemoryShoppingCartReadDataAccessObject implements ShoppingCartReadDataAccessInterface {

    @Override
    public ShoppingCart getShoppingCart(String userID) throws SQLException, IOException {
        return null;
    }
}
