package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * The BuyerSelectScheduleInputData class holds the data required to select a schedule
 * for a buyer.
 */
public class BuyerSelectScheduleInputData {
    private User buyer;
    private Product product;
    private LocalDateTime selectedTime;

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

    /**
     * Gets the buyer selecting the schedule.
     *
     * @return the buyer
     */
    public User getBuyer() {
        return buyer;
    }

    /**
     * Gets the product associated with the schedule.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the selected schedule time.
     *
     * @return the selected schedule time
     */
    public LocalDateTime getSelectedTime() {
        return selectedTime;
    }
}

