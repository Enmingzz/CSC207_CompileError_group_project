package use_case.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class SearchProductByTagOutputData {
    private User user;
    private final ArrayList<Product> products;

    public SearchProductByTagOutputData(User user, ArrayList<Product> products) {
        this.user = user;
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }
}
