package use_case.modify_product;
import entity.product.Product;
import entity.user.User;

import java.awt.*;

public class ChangeProductInputData {
    private final User user;
    private final String changedDescription ;
    private final String changedPrice;
    private final String address;
    private final String title;
    private final String email;
    private final Product product;
    private final Image image;

    public ChangeProductInputData(User user, Product product, String changedDescription, String changedPrice,
                                  String address, String title, String email, Image image) {
        this.user = user;
        this.product = product;
        this.changedDescription = changedDescription;
        this.changedPrice = changedPrice;
        this.address = address;
        this.title = title;
        this.email = email;
        this.image = image;
    }
    public User getUser() {
        return user;
    }
    public String getChangedPrice() {
        return changedPrice;
    }
    public String getChangedDescription() {
        return changedDescription;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getTitle() {
        return title;
    }
    public Image getImage() {
        return image;
    }

    public Product getProduct() {
        return product;
    }
}
