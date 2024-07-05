package interface_adapter.profile.view_profile;

import entity.product.Product;
import entity.user.User;
import entity.user.UserFactory;

import java.util.ArrayList;

public class ViewProfileState {

    private User user;
    private ArrayList<Product> products;

    public ViewProfileState(UserFactory commonUserFactory) {
        this.user = commonUserFactory.createUser("", "", "", 0, "");
        this.products = new ArrayList<Product>();
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
