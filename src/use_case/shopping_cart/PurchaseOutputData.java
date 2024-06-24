package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;

public class PurchaseOutputData {
    private final User user;
    private final Product purchasedProduct;

    public PurchaseOutputData(User user, Product purchasedProduct){
        this.purchasedProduct = purchasedProduct;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return purchasedProduct;
    }
}
