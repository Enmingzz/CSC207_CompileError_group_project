package interface_adapter.profile.view_profile;

import entity.product.Product;
import entity.user.User;
import entity.user.UserFactory;
import java.util.ArrayList;

/**
 * Represents the state for viewing another user's profile, including the seller, buyer, and list of products.
 */
public class ViewUserProfileState {

    private User sellerUser;
    private User buyerUser;
    private ArrayList<Product> listProduct = new ArrayList<>();
    /**
     * Constructs a {@link ViewUserProfileState} with the specified user factory.
     *
     * @param commonUserFactory the factory to create the seller and buyer users
     */
    public ViewUserProfileState(UserFactory commonUserFactory) {
        this.sellerUser = commonUserFactory.createUser("", "", "", 0, "");
        this.buyerUser = commonUserFactory.createUser("", "", "", 0, "");
    }
    /**
     * Constructs a {@link ViewUserProfileState} with the specified buyer user.
     *
     * @param user the buyer user to initialize the state with
     */
    public ViewUserProfileState(User user) {
        this.buyerUser = user;
    }
    /**
     * Gets the seller user.
     *
     * @return the seller user
     */
    public User getSellerUser() {
        return sellerUser;
    }
    /**
     * Sets the seller user.
     *
     * @param sellerUser the seller user to set
     */
    public void setSellerUser(User sellerUser) {
        this.sellerUser = sellerUser;
    }
    /**
     * Gets the buyer user.
     *
     * @return the buyer user
     */
    public User getBuyerUser() {
        return buyerUser;
    }
    /**
     * Sets the buyer user.
     *
     * @param buyerUser the buyer user to set
     */
    public void setBuyerUser(User buyerUser) {
        this.buyerUser = buyerUser;
    }
    /**
     * Gets the list of products.
     *
     * @return the list of products
     */
    public ArrayList<Product> getListProduct() {
        return listProduct;
    }
    /**
     * Sets the list of products.
     *
     * @param listProduct the list of products to set
     */
    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
