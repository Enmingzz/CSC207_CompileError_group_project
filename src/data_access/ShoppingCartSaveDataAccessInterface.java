package data_access;

import entity.ShoppingCart;
import entity.Product;

public interface ShoppingCartSaveDataAccessInterface {
    // To be implemented to get the UtorID in shoppingCart and ProductID in product to be written in database
    void save(ShoppingCart shoppingCart, Product product);
}
