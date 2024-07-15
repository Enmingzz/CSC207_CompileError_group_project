package use_case.profile.manage_product;


import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class ManageProductOutputData {
    private ArrayList<Product> products;
    private User user;

    public ManageProductOutputData(ArrayList<Product> products, User user) {
        this.user = user;
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public User getUser(){return user;}

}
