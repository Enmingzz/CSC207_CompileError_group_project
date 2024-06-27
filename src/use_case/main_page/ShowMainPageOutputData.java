package use_case.main_page;

import java.lang.reflect.Array;
import java.util.ArrayList;
import entity.product.Product;
import entity.user.User;

public class ShowMainPageOutputData {
    private final User user;
    private final ArrayList<Product> allProducts;

    public ShowMainPageOutputData(User user, ArrayList<Product> allProducts) {
        this.user = user;
        this.allProducts = allProducts;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }
}
