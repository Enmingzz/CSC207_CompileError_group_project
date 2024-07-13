package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

public class ViewModifyProductInputData {
    private final User user;
    private final Product product;

    public ViewModifyProductInputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
}
