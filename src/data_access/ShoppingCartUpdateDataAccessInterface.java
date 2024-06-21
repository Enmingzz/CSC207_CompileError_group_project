package data_access;

import java.sql.SQLException;
import entity.Product;
import entity.User;

public interface ShoppingCartUpdateDataAccessInterface {
    // To be implemented to get the UtorID in shoppingCart and ProductID in product to be written in database
    void updateAddShoppingCart(User shoppingCartUser, Product addedProduct) throws SQLException;
    void updateDeleteShoppingCart(User shoppingCartUser, Product addedProduct) throws SQLException;
}
