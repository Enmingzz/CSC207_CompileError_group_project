package entity;

import java.util.ArrayList;

public class CommonUserFactory implements UserFactory{
    public User createUser(String name, String Password, String email, ArrayList<Product> ProductList, ShoppingCart userCart, float userRating, String Utorid){
        return new CommonUser(name, Password, email, ProductList, userCart, userRating, Utorid);
    }
}
