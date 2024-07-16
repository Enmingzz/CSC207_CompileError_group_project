package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;

//TODO might need to change to only able to get instead of get and change product and user

public class RateProductState {
    private String rating = "";
    private String ratingError = null;
    private Product product = null;
    private User user = null;

    public RateProductState(RateProductState copy) {
        rating = copy.rating;
        ratingError = copy.ratingError;
        product = copy.product;
        user = copy.user;
    }

    public RateProductState() {}

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public String getRatingError() {
        return ratingError;
    }

    public void setRatingError(String error) {
        this.ratingError = error;
    }
}
