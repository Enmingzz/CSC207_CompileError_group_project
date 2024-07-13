package use_case.modify_product;
import entity.product.Product;
import entity.user.User;

import java.awt.*;

public class ChangeProductInputData {
    private final User user;
    private final String changedDescription ;
    private final String changedPrice;
    private final Image changedImage;
    private final Product product;

    public ChangeProductInputData(User user, Product product, String changedDescription, String changedPrice, Image changedImage) {
        this.user = user;
        this.product = product;
        this.changedDescription = changedDescription;
        this.changedPrice = changedPrice;
        this.changedImage = changedImage;
    }
    public User getUser() {
        return user;
    }
    public Image getChangedImage() {
        return changedImage;
    }
    public String getChangedPrice() {
        return changedPrice;
    }
    public String getChangedDescription() {
        return changedDescription;
    }

    public Product getProduct() {
        return product;
    }
}
