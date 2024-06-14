package entity;

import java.util.ArrayList;

public interface ShoppingCartFactory {
    ShoppingCart createShoppingCart(float totalPrice, CommonUser user, ArrayList<Product> listProducts);
}
