package use_case.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class GetSearchViewOutputData {
    private final User user;
    private final ArrayList<Product> allProducts;

    public GetSearchViewOutputData(User user, ArrayList<Product> allProducts) {
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
