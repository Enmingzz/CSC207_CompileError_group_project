package use_case.schedule;

import entity.product.Product;
import entity.user.User;


public class SellerSelectScheduleOutputData {
    private User buyer;
    private Product product;

    public SellerSelectScheduleOutputData(User buyer, Product product) {
        this.buyer = buyer;
        this.product = product;
    }

    public User getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }
}
