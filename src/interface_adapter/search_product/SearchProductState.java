package interface_adapter.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class SearchProductState {
    private User user = null;
    private ArrayList<Product> products = new ArrayList<>();

    public SearchProductState() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
