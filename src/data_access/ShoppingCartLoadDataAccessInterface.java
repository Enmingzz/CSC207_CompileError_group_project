package data_access;

import entity.ShoppingCart;
import entity.User;

public interface ShoppingCartLoadDataAccessInterface {
    ShoppingCart load(User user);
}
