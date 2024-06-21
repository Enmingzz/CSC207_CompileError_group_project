package interface_adapter;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;



public class ShoppingCartState {
    private ArrayList<Product> listProducts;
    private User user;

    public ShoppingCartState(ShoppingCartState copy) {
        listProducts = copy.listProducts;
        user = copy.user;
    }

    public ShoppingCartState() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
}
