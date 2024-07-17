package entity.shopping_cart;

import entity.product.Product;

import java.util.ArrayList;

public class CommonShoppingCartFactory implements ShoppingCartFactory{

    /**
     * Creates a new instance of {@link CommonShoppingCart} with the specified total price, student number, and list of products.
     *
     * @param totalPrice   the total price of the products in the shopping cart
     * @param studentNumber the student number associated with the shopping cart
     * @param listProducts the list of products in the shopping cart
     * @return a new {@link CommonShoppingCart} instance
     */

    public ShoppingCart createShoppingCart(float totalPrice, String studentNumber, ArrayList<Product> listProducts) {
        return new CommonShoppingCart(totalPrice, studentNumber, listProducts);
    }
}
