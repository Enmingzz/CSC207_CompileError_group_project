package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryShoppingCartUpdateAddDataAccessObject implements ShoppingCartUpdateAddDataAccessInterface {


    @Override
    public void updateShoppingCart(User user, Product product) throws SQLException {

    }
}
