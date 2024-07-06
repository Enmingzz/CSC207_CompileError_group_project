package interface_adapter.schedule;

import entity.user.User;
import entity.product.Product;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SellerSelectScheduleState {
    private User seller;
    private Product product;
    private List<LocalDateTime> availableTimes;

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

    public List<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<LocalDateTime> availableTimes) {
        this.availableTimes = availableTimes.stream()
                .map(this::truncateToHour)
                .collect(Collectors.toList());
    }

    private LocalDateTime truncateToHour(LocalDateTime time) {
        return time.withMinute(0).withSecond(0).withNano(0);
    }
}
