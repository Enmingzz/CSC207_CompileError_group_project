package entity.shopping_cart;

import entity.product.Product;

import java.util.ArrayList;

/**
 * Provide the interface of CommonShoppingCart
 * @author CompileError group
 */

public interface ShoppingCart {
    float getTotalPrice();

    String getStudentNumber();

    ArrayList<Product> getListProducts();
}
