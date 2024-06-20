package entity;

import java.util.ArrayList;

public interface ShoppingCartFactory {
    ShoppingCart createShoppingCart(float totalPrice, String studentNumber, ArrayList<Product> listProducts);
}
