package interface_adapter.profile.manage_product;

import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.User;

import java.util.ArrayList;

public class ManageProductState {
    private Product product;
    private User user;
    private ArrayList<Product> products = new ArrayList<Product>();
    private String modifyProductMessage = null;

    public ManageProductState(ProductFactory productFactory) {
    }

    public User getUser(){return user;}

    public ArrayList<Product> getProduct() {return products;}

    public void setUser(User user){this.user = user;}

    public void setProduct(ArrayList<Product> products) {this.products = products;}

    public String getModifyProductMessage() {return modifyProductMessage;}

    public void setModifyProductMessage(String message) {this.modifyProductMessage = message;}
}
