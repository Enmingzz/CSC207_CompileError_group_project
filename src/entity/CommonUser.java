package entity;

import java.util.ArrayList;

public class CommonUser implements User{
    String name;
    String password;
    String email;
    ArrayList<Product> productList;
    ShoppingCart userCart;
    float userRating;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public ShoppingCart getUserCart() {
        return userCart;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public float getUserRating() {
        return userRating;
    }
}
