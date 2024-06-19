package entity;

import java.util.ArrayList;

public interface ShoppingCart {
    float getTotalPrice();

    CommonUser getUser();

    ArrayList<Product> getListProducts();
}
