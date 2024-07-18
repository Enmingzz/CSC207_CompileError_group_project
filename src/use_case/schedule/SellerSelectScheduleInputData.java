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
    private final User seller;
    private final Product product;
    private final ArrayList<LocalDateTime> availableTimes;

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

    public User getSeller() {
        return seller;
    }

    public Product getProduct () {
        return product;
    }

    public ArrayList<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }
}
