package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;
import use_case.rate_product.RateProductInputBoundary;
import use_case.rate_product.RateProductInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller class for handling product rating actions.
 * It acts as an intermediary between the UI and the application logic.
 */
public class RateProductController {
    private final RateProductInputBoundary rateProductInputBoundary;

    /**
     * Constructs a RateProductController with the specified input boundary.
     *
     * @param rateProductInputBoundary The input boundary for the rate product use case.
     */
    public RateProductController(RateProductInputBoundary rateProductInputBoundary) {
        this.rateProductInputBoundary = rateProductInputBoundary;
    }

    /**
     * Executes the rate product use case.
     *
     * @param user    The user who is rating the product.
     * @param product The product being rated.
     * @param rating  The rating given to the product by the user.
     * @throws SQLException If there is a SQL related error during execution.
     * @throws IOException  If there is an IO related error during execution.
     */
    public void execute(User user, Product product, String rating) throws SQLException, IOException {
        RateProductInputData rateProductInputData = new RateProductInputData(user, rating, product);
        rateProductInputBoundary.execute(rateProductInputData);
    }
}
