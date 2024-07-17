package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * The BuyerSelectScheduleState class holds the state information for the buyer select schedule use case,
 * including the buyer, product, and any error messages.
 */
public class BuyerSelectScheduleState {

    private User buyer = null;
    private Product product = null;
    private String error = null;

    /**
     * Constructs a new BuyerSelectScheduleState object as a copy of the specified state.
     *
     * @param copy the state to copy
     */
    public BuyerSelectScheduleState(BuyerSelectScheduleState copy) {
        buyer = copy.buyer;
        product = copy.product;
        error = copy.error;
    }

    /**
     * Constructs a BuyerSelectScheduleState object with default values.
     */
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

