package entity;

import java.util.ArrayList;

public interface ShoppingCart {
    float getTotalPrice();

    String getStudentNumber();

    ArrayList<Product> getListProducts();
}
