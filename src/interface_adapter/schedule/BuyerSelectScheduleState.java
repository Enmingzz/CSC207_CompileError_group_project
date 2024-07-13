package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

public class BuyerSelectScheduleState {

    private User buyer = null;
    private Product product = null;
    private String error = null;

    public BuyerSelectScheduleState(BuyerSelectScheduleState copy) {
        buyer = copy.buyer;
        product = copy.product;
        error = copy.error;
    }

    public BuyerSelectScheduleState () {}

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

