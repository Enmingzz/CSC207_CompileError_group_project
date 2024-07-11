package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

public class BuyerSelectScheduleOutputData {
    private User buyer;
    private Product product;

    public BuyerSelectScheduleOutputData(User buyer, Product product) {
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
