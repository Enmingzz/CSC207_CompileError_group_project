package entity;

import java.util.ArrayList;

public interface ShoppingCart {
    public float getTotalPrice();

    public CommonUser getUser();

    public ArrayList<Product> getListProducts();
}
