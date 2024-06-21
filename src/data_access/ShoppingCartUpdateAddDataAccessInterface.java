package data_access;

import entity.ShoppingCart;
import entity.Product;
import entity.User;

import java.sql.SQLException;

public interface ShoppingCartUpdateAddDataAccessInterface {
    // To be implemented to get the UtorID in shoppingCart and ProductID in product to be written in database
    void updateShoppingCart(User user, Product product) throws SQLException;
}
