package use_case.schedule;

import entity.product.Product;
import entity.user.User;

/**
 * The SellerSelectScheduleOutputData class holds the data required for the output
 * of the schedule selection process for a seller, including the seller and updated product information.
 */
public class SellerSelectScheduleOutputData {
    private User seller;
    private Product product;

    /**
     * Constructs a SellerSelectScheduleOutputData object.
     *
     * @param seller the seller selecting the schedule
     * @param product the updated product after schedule selection
     */
    public SellerSelectScheduleOutputData(User seller, Product product) {
        this.seller = seller;
        this.product = product;
    }

    public User getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }
}
