package entity;

import java.util.ArrayList;

public interface UserFactory {
    public User createUser(String name, String Password, String email, ArrayList<Product> ProductList, ShoppingCart userCart, float userRating);

    public static void main(String[] args) {
        System.out.println("nibuhao");
    }
}
