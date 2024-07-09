package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

public class BuyerSelectScheduleState {

    private User buyer = null;
    private Product product = null;

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

