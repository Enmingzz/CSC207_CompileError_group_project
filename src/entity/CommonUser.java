package entity;

import java.util.ArrayList;

public class CommonUser implements User{
    String name;
    String password;
    String email;
    ArrayList<Product> productList;
    ShoppingCart userCart;
    float userRating;

    public CommonUser(String name, String Password, String email, ArrayList<Product> ProductList, ShoppingCart userCart, float userRating){
        this.name = name;
        this.password = Password;
        this.email = email;
        this.productList = ProductList;
        this.userCart = userCart;
        this.userRating = userRating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public ShoppingCart getUserCart() {
        return userCart;
    }

    @Override
    public ArrayList<Product> getProductList() {
        return productList;
    }

    @Override
    public float getUserRating() {
        return userRating;
    }
}