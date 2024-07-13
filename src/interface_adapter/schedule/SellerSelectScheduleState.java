package interface_adapter.schedule;

import entity.user.User;
import entity.product.Product;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SellerSelectScheduleState {
    private User seller = null;
    private Product product = null;
    private String error = null;

    public SellerSelectScheduleState(SellerSelectScheduleState copy) {
        seller = copy.seller;
        product = copy.product;
        error = copy.error;
    }

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
