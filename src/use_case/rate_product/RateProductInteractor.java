package use_case.rate_product;

import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;

public class RateProductInteractor implements RateProductInputBoundary{
    private final ProductUpdateRatingDataAccessInterface productUpdateRatingDataAccessInterface;
    private final ProductUpdateStateDataAccessInterface productUpdateStateDataAccessInterface;
    private final RateProductOutputBoundary rateProductOutputBoundary;

    public RateProductInteractor(ProductUpdateRatingDataAccessInterface productUpdateRatingDataAccessInterface, ProductUpdateStateDataAccessInterface productUpdateStateDataAccessInterface, RateProductOutputBoundary rateProductOutputBoundary) {
        this.productUpdateRatingDataAccessInterface = productUpdateRatingDataAccessInterface;
        this.productUpdateStateDataAccessInterface = productUpdateStateDataAccessInterface;
        this.rateProductOutputBoundary = rateProductOutputBoundary;
    }

    public void execute(RateProductInputData rateProductInputData) throws SQLException, IOException {
        boolean validRating;
        int intRating = 0;
        try {
            intRating = Integer.parseInt(rateProductInputData.getRating());
            if(intRating > 0 & intRating <= 5) {
                validRating = true;
            }
            else{
                validRating = false;
            }
        } catch (NumberFormatException e) {
            validRating = false;
            rateProductOutputBoundary.prepareFailedView("You must input a valid integral rating from 1 to 5.");
        }

        if(validRating) {
            productUpdateStateDataAccessInterface.updateProductState(rateProductInputData.getProduct(), 1);
            productUpdateRatingDataAccessInterface.updateProductRating(rateProductInputData.getProduct(), intRating);

            RateProductOutputData rateProductOutputData = new RateProductOutputData(rateProductInputData.getUser(), rateProductInputData.getProduct());
            rateProductOutputBoundary.prepareSuccessfulView(rateProductOutputData);
        }

    }
}
