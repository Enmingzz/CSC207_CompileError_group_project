package interface_adapter.shopping_cart;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;



public class ShoppingCartState {
    private ArrayList<Product> listProducts = new ArrayList<>();
    private User user = null;
    private float totalPrice = 0;
    private String errorMessage = "";

    public ShoppingCartState(ShoppingCartState copy) {
        listProducts = copy.listProducts;
        user = copy.user;
        totalPrice = copy.totalPrice;
        errorMessage = copy.errorMessage;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
