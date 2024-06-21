package entity.shopping_cart;

import entity.product.Product;

import java.util.ArrayList;

public interface ShoppingCart {
    float getTotalPrice();

    String getStudentNumber();

    ArrayList<Product> getListProducts();
}
