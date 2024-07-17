package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * The BuyerSelectScheduleOutputData class holds the data required for the output
 * of the schedule selection process.
 */
public class BuyerSelectScheduleOutputData {
    private User buyer;
    private Product product;

    /**
     * Constructs a BuyerSelectScheduleOutputData object.
     *
     * @param buyer the buyer who selected the schedule
     * @param product the updated product information after schedule selection
     */
    public BuyerSelectScheduleOutputData(User buyer, Product product) {
        this.buyer = buyer;
        this.product = product;
    }

    /**
     * Gets the buyer who selected the schedule.
     *
     * @return the buyer
     */
    public User getBuyer() {
        return buyer;
    }

    /**
     * Gets the updated product after schedule selection.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

}
