package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

public class BuyerSelectScheduleInputData {
    private User buyer;
    private Product product;
    private LocalDateTime selectedTime;

    public BuyerSelectScheduleInputData(User buyer, Product product, LocalDateTime selectedTime) {
        this.buyer = buyer;
        this.product = product;
        this.selectedTime = selectedTime;
    }

    public User getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getSelectedTime() {
        return selectedTime;
    }
}

