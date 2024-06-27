package interface_adapter.main_page;

import java.util.ArrayList;
import entity.product.Product;
import entity.user.User;

public class MainPageState {

    private User user = null;
    private ArrayList<Product> allProducts = new ArrayList<>();

    public MainPageState() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    }
}