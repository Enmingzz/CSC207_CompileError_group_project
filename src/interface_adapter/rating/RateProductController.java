package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;
import use_case.rate_product.RateProductInputBoundary;
import use_case.rate_product.RateProductInputData;

import java.io.IOException;
import java.sql.SQLException;

public class RateProductController {
    private final RateProductInputBoundary rateProductInputBoundary;

    public RateProductController(RateProductInputBoundary rateProductInputBoundary) {
        this.rateProductInputBoundary = rateProductInputBoundary;
    }

    public void execute(User user, Product product, String rating) throws SQLException, IOException {
        RateProductInputData rateProductInputData = new RateProductInputData(user, rating, product);
        rateProductInputBoundary.execute(rateProductInputData);
    }
}
