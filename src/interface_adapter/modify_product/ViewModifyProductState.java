package interface_adapter.modify_product;

import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.User;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;

public class ViewModifyProductState {
    private User user;
    private Product product;
    private String description = "";
    private String price = "";

    public ViewModifyProductState(User user, Product product, String description, String price) {
        this.user = user;
        this.product = product;
        this.description = description;
        this.price = price;
    }

    public ViewModifyProductState(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public ViewModifyProductState() {
    }

    public User getUser() {return user;}

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
