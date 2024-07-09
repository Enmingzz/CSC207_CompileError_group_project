package use_case.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class SearchProductByNameOutputData {
    private final User user;
    private final ArrayList<Product> products;

    public SearchProductByNameOutputData(User user, ArrayList<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
