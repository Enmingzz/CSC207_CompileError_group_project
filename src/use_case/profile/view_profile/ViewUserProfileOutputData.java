package use_case.profile.view_profile;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * Output data class for viewing a user's profile.
 * This class holds the data required for presenting a user's profile, including the seller's information, buyer's information, and a list of products.
 */
public class ViewUserProfileOutputData {

    private final User seller;
    private final User buyer;
    private final ArrayList<Product> productList;

    /**
     * Constructs a ViewUserProfileOutputData with the specified seller, buyer, and product list.
     *
     * @param seller the seller's information
     * @param buyer the buyer's information
     * @param productList the list of products associated with the seller
     */
    public ViewUserProfileOutputData(User seller, User buyer, ArrayList<Product> productList) {
        this.seller = seller;
        this.buyer = buyer;
        this.productList = productList;
    }

    /**
     * Returns the seller's information.
     *
     * @return the seller's information
     */
    public User getSeller() {
        return seller;
    }

    /**
     * Returns the buyer's information.
     *
     * @return the buyer's information
     */
    public User getBuyer() {
        return buyer;
    }

    /**
     * Returns the list of products associated with the seller.
     *
     * @return the list of products
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
