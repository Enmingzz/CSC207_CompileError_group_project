package use_case.modify_product;
import entity.product.Product;
import entity.user.User;

import java.awt.*;

public class ChangeProductInputData {
    private final User user;
    private final String changedDescription ;
    private final String changedPrice;
    private final Product product;

    public ChangeProductInputData(User user, Product product, String changedDescription, String changedPrice) {
        this.user = user;
        this.product = product;
        this.changedDescription = changedDescription;
        this.changedPrice = changedPrice;
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

    public Product getProduct() {
        return product;
    }
}
