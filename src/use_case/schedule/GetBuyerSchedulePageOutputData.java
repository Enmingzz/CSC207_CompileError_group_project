package use_case.schedule;

import entity.product.Product;
import entity.user.User;

/**
 * The GetBuyerSchedulePageOutputData class holds the data required for the output
 * of retrieving the schedule page for a buyer.
 */
public class GetBuyerSchedulePageOutputData {
    private final User buyer;
    private Product product;

    /**
     * Constructs a GetBuyerSchedulePageOutputData object.
     *
     * @param buyer the buyer requesting the schedule page
     * @param product the product associated with the schedule
     */
    public  GetBuyerSchedulePageOutputData(User buyer, Product product) {
        this.buyer = buyer;
        this.product = product;
    }

    /**
     * Gets the product associated with the schedule.
     *
     * @return the product
     */
    public User getBuyer(){
        return buyer;
    }

    /**
     * Gets the buyer requesting the schedule page.
     *
     * @return the buyer
     */
    public  Product getProduct() {
        return product;
    }
}
