package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;

/**
 * Represents the state of the rating process for a product by a user.
 * Contains the rating, rating error, product, and user details.
 */
public class RateProductState {
    private String rating = "";
    private String ratingError = null;
    private Product product = null;
    private User user = null;

    /**
     * Copy constructor. Creates a new RateProductState by copying the values from another RateProductState.
     *
     * @param copy The RateProductState to copy from.
     */
    public RateProductState(RateProductState copy) {
        this.rating = copy.rating;
        this.ratingError = copy.ratingError;
        this.product = copy.product;
        this.user = copy.user;
    }

    /**
     * Default constructor. Initializes a new instance of RateProductState with default values.
     */
    public RateProductState() {}

    /**
     * Gets the rating.
     *
     * @return The rating.
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the rating.
     *
     * @param rating The rating to set.
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Gets the product being rated.
     *
     * @return The product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product being rated.
     *
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the user who is rating the product.
     *
     * @return The user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who is rating the product.
     *
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the rating error.
     *
     * @return The rating error.
     */
    public String getRatingError() {
        return ratingError;
    }

    /**
     * Sets the rating error.
     *
     * @param error The rating error to set.
     */
    public void setRatingError(String error) {
        this.ratingError = error;
    }
}
