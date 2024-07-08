package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

public class BuyerSelectScheduleState {

    private User buyer = null;
    private Product product = null;
    private LocalDateTime selectedTime = ;

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

    public LocalDateTime getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(LocalDateTime selectedTime) {
        this.selectedTime = truncateToHour(selectedTime);
    }

    private LocalDateTime truncateToHour(LocalDateTime time) {
        return time.withMinute(0).withSecond(0).withNano(0);
    }
}

