package entity.shopping_cart;

import entity.product.Product;

import java.util.ArrayList;

public class CommonShoppingCartFactory implements ShoppingCartFactory{
    public ShoppingCart createShoppingCart(float totalPrice, String studentNumber, ArrayList<Product> listProducts) {
        return new CommonShoppingCart(totalPrice, studentNumber, listProducts);
    }
}
