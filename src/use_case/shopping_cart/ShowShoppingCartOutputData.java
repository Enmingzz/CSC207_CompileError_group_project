package use_case.shopping_cart;

import entity.shopping_cart.ShoppingCart;
import entity.user.User;

public class ShowShoppingCartOutputData {

    User user;
    ShoppingCart shoppingCart;

    public ShowShoppingCartOutputData(User user, ShoppingCart shoppingCart) {
        this.user = user;
        this.shoppingCart = shoppingCart;
    }

    public User getUser() {
        return user;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
