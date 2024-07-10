package interface_adapter.schedule;

import entity.user.User;
import entity.product.Product;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SellerSelectScheduleState {
    private User seller = null;
    private Product product = null;

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


    private LocalDateTime truncateToHour(LocalDateTime time) {
        return time.withMinute(0).withSecond(0).withNano(0);
    }
}
