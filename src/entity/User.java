package entity;

import java.util.ArrayList;

public interface User {

    public String getName();

    public String getPassword();

    public String getEmail();

    public ShoppingCart getUserCart();

    public ArrayList<Product> getProductList();

    public float getUserRating();

    public String getUtroid();
}
