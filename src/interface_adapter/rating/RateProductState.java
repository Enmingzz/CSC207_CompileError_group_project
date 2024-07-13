package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;

public class RateProductState {
    private String rating = "";
    private String ratingError = null;

    public RateProductState(RateProductState copy) {
        rating = copy.rating;
        ratingError = copy.ratingError;
    }

    public RateProductState() {}

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingError() {
        return ratingError;
    }

    public void setRatingError(String error) {
        this.ratingError = error;
    }
}
