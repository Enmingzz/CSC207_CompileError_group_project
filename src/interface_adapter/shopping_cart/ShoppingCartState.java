package interface_adapter.shopping_cart;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;



public class ShoppingCartState {
    private ArrayList<Product> listProducts;
    private User user;
    private float totalPrice;

    public ShoppingCartState(ShoppingCartState copy) {
        listProducts = copy.listProducts;
        user = copy.user;
        totalPrice = copy.totalPrice;
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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }
}
