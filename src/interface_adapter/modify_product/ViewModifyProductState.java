package interface_adapter.modify_product;

import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.User;
import interface_adapter.ViewModel;

import java.awt.*;
import java.beans.PropertyChangeSupport;

public class ViewModifyProductState {
    private User user = null;
    private Product product = null;

    private String description = "";
    private String price = "";
    private String address = "";
    private String title = "";
    private String email = "";
    private String message = "";

    private String path = "";
    private Image image = null;

    public ViewModifyProductState(User user, Product product,
                                  String description, String price, String email, String title, String address) {
        this.user = user;
        this.product = product;

        this.description = description;
        this.email = price;
        this.title = price;
        this.address = price;
        this.price = price;
    }

//    public ViewModifyProductState(String description, String price) {
//        this.description = description;
//        this.price = price;
//    }

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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {this.email = email;}

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }


}
