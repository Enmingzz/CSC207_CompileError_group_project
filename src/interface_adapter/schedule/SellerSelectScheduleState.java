package interface_adapter.schedule;

import entity.user.User;
import entity.product.Product;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The SellerSelectScheduleState class holds the state information for the seller select schedule use case,
 * including the seller, product, and any error messages.
 */
public class SellerSelectScheduleState {
    private User seller = null;
    private Product product = null;
    private String error = null;

    /**
     * Constructs a new SellerSelectScheduleState object as a copy of the specified state.
     *
     * @param copy the state to copy
     */
    public SellerSelectScheduleState(SellerSelectScheduleState copy) {
        seller = copy.seller;
        product = copy.product;
        error = copy.error;
    }

    /**
     * Constructs a SellerSelectScheduleState object with default values.
     */
    public SellerSelectScheduleState () {}

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
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
