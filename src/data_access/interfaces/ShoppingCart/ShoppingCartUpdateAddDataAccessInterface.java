package data_access.interfaces.ShoppingCart;

import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

public interface ShoppingCartUpdateAddDataAccessInterface {
    // To be implemented to get the UtorID in shoppingCart and ProductID in modify_product to be written in database
    void updateShoppingCart(User user, Product product) throws SQLException;
}
