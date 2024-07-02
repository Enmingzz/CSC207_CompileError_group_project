package interface_adapter.shopping_cart;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;
import java.util.List;



public class ShoppingCartState {
    private List<Product> listProducts = new ArrayList<>();
    private User user = null;
    private float totalPrice = 0;

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

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }
}
