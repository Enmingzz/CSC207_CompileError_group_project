package use_case.schedule;

import entity.product.Product;
import entity.user.User;

/**
 * The GetSellerSchedulePageOutputData class holds the data required for the output
 * of gathering the necessary data to display the schedule page for a seller.
 */
public class GetSellerSchedulePageOutputData {
    private final User seller;
    private Product product;

    /**
     * Constructs a GetSellerSchedulePageOutputData object.
     *
     * @param seller the seller requesting the schedule page
     * @param product the product associated with the schedule
     */
    public  GetSellerSchedulePageOutputData(User seller, Product product) {
        this.seller = seller;
        this.product = product;
    }

    public User getSeller(){
        return seller;
    }

    public  Product getProduct() {
        return product;
    }
}
