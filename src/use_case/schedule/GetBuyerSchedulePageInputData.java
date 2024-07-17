package use_case.schedule;

import entity.product.Product;
import entity.user.User;

/**
 * The GetBuyerSchedulePageInputData class holds the data required to retrieve the
 * schedule page for a buyer.
 */
public class GetBuyerSchedulePageInputData {
    private User buyer;
    private final Product product;


    /**
     * Constructs a GetBuyerSchedulePageInputData object.
     *
     * @param buyer the buyer requesting the schedule page
     * @param product the product associated with the schedule
     */
    public GetBuyerSchedulePageInputData(User buyer, Product product){
        this.product = product;
        this.buyer = buyer;
    }

    /**
     * Gets the product associated with the schedule.
     *
     * @return the product
     */
    public Product getProduct(){
        return product;
    }

    /**
     * Gets the buyer requesting the schedule page.
     *
     * @return the buyer
     */
    public User getBuyer(){
        return buyer;
    }
}

