package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * The BuyerSelectScheduleInputData class holds the data required to select a schedule
 * for a buyer.
 */
public class BuyerSelectScheduleInputData {
    private final User buyer;
    private final Product product;
    private final LocalDateTime selectedTime;

    /**
     * Constructs a BuyerSelectScheduleInputData object with the specified buyer, product, and selected time.
     *
     * @param buyer the buyer selecting the schedule
     * @param product the product associated with the schedule
     * @param selectedTime the selected schedule time
     */
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

