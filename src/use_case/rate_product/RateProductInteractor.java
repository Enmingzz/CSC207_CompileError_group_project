package use_case.rate_product;

import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The RateProductInteractor class is responsible for handling the process of rating a product.
 * It implements the {@link RateProductInputBoundary} interface and uses {@link ProductUpdateRatingDataAccessInterface}
 * and {@link ProductUpdateStateDataAccessInterface} to interact with the data access layer. It also uses a
 * {@link RateProductOutputBoundary} to present the result of the operation.
 */
public class RateProductInteractor implements RateProductInputBoundary {

    private final ProductUpdateRatingDataAccessInterface productUpdateRatingDataAccessInterface;
    private final ProductUpdateStateDataAccessInterface productUpdateStateDataAccessInterface;
    private final RateProductOutputBoundary rateProductOutputBoundary;

    /**
     * Constructs a RateProductInteractor instance with the specified data access interfaces and output boundary.
     *
     * @param productUpdateRatingDataAccessInterface the interface for updating the product rating in the data access layer
     * @param productUpdateStateDataAccessInterface the interface for updating the product state in the data access layer
     * @param rateProductOutputBoundary the presenter for handling output data and displaying messages
     */
    public RateProductInteractor(ProductUpdateRatingDataAccessInterface productUpdateRatingDataAccessInterface,
                                 ProductUpdateStateDataAccessInterface productUpdateStateDataAccessInterface,
                                 RateProductOutputBoundary rateProductOutputBoundary) {
        this.productUpdateRatingDataAccessInterface = productUpdateRatingDataAccessInterface;
        this.productUpdateStateDataAccessInterface = productUpdateStateDataAccessInterface;
        this.rateProductOutputBoundary = rateProductOutputBoundary;
    }

    /**
     * Executes the process of rating a product. Validates the rating input, updates the product's state and rating
     * if the rating is valid, and informs the presenter to prepare the appropriate view.
     *
     * <p>If the rating is invalid (not an integer between 1 and 5), a failure message is sent to the presenter.</p>
     *
     * @param rateProductInputData the input data required for rating the product, including the user and product information
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void execute(RateProductInputData rateProductInputData) throws SQLException, IOException {
        boolean validRating;
        int intRating = 0;
        try {
            intRating = Integer.parseInt(rateProductInputData.getRating());
            if (intRating > 0 && intRating <= 5) {
                validRating = true;
            } else {
                validRating = false;
            }
        } catch (NumberFormatException e) {
            validRating = false;
            rateProductOutputBoundary.prepareFailedView("You must input a valid integral rating from 1 to 5.");
        }

        if (validRating) {
            productUpdateStateDataAccessInterface.updateProductState(rateProductInputData.getProduct(), -1);
            productUpdateRatingDataAccessInterface.updateProductRating(rateProductInputData.getProduct(), intRating);

            RateProductOutputData rateProductOutputData = new RateProductOutputData(rateProductInputData.getUser(), rateProductInputData.getProduct());
            rateProductOutputBoundary.prepareSuccessfulView(rateProductOutputData);
        } else {
            rateProductOutputBoundary.prepareFailedView("You must input a valid integral rating from 1 to 5.");
        }
    }
}
