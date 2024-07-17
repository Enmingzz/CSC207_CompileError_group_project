package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The SellerSelectScheduleInputData class holds the data required for selecting a schedule
 * for a seller.
 */
public class SellerSelectScheduleInputData {
    private User seller;
    private Product product;
    private ArrayList<LocalDateTime> availableTimes;

    /**
     * Constructs a SellerSelectScheduleInputData object.
     *
     * @param seller the seller selecting the schedule
     * @param product the product associated with the schedule
     * @param availableTimes the list of available schedule times
     */
    public SellerSelectScheduleInputData(User seller, Product product, ArrayList<LocalDateTime> availableTimes) {
        this.seller = seller;
        this.product = product;
        this.availableTimes = availableTimes;
    }

    /**
     * Gets the seller selecting the schedule.
     *
     * @return the seller
     */
    public User getSeller() {
        return seller;
    }

    /**
     * Gets the product associated with the schedule.
     *
     * @return the product
     */
    public Product getProduct () {
        return product;
    }

    /**
     * Returns the list of available schedule times.
     *
     * @return the available times
     */
    public ArrayList<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }
}
