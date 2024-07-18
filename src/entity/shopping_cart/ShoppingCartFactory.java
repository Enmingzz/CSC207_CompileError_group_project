package entity.shopping_cart;

import entity.product.Product;

import java.util.ArrayList;

/**
 * Provide the interface of CommonShoppingCartFactory
 * @author CompileError group
 */

public interface ShoppingCartFactory {
    ShoppingCart createShoppingCart(float totalPrice, String studentNumber, ArrayList<Product> listProducts);
}
