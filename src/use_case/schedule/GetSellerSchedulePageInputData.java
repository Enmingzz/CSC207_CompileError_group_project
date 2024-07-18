package use_case.schedule;

import entity.product.Product;
import entity.user.User;

/**
 * The GetSellerSchedulePageInputData class holds the data required to retrieve the
 * schedule page for a seller, including the seller and product information.
 */
public class GetSellerSchedulePageInputData {
    private final User seller;
    private final Product product;


    /**
     * Constructs a GetSellerSchedulePageInputData object.
     *
     * @param seller the seller requesting the schedule page
     * @param product the product associated with the schedule
     */
    public GetSellerSchedulePageInputData(User seller, Product product){
        this.product = product;
        this.seller = seller;
    }

    public Product getProduct(){
        return product;
    }

    public User getSeller(){
        return seller;
    }
}
