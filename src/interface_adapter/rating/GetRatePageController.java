package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;
import use_case.rate_product.GetRatePageInputBoundary;
import use_case.rate_product.GetRatePageInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for handling requests to get the rate page for a product.
 *
 * This class interacts with the use case layer to retrieve the rating page
 * details for a given product and user. It prepares the input data required
 * for the use case and invokes the interactor to process the request.
 */
public class GetRatePageController {
    private final GetRatePageInputBoundary getRatePageInteractor;

    /**
     * Constructs a GetRatePageController with the specified input boundary.
     *
     * @param getRatePageInteractor The interactor that handles the logic for getting the rate page.
     */
    public GetRatePageController(GetRatePageInputBoundary getRatePageInteractor) {
        this.getRatePageInteractor = getRatePageInteractor;
    }

    /**
     * Executes the request to get the rate page for a product.
     *
     * This method creates an instance of GetRatePageInputData with the provided
     * user and product information, and then invokes the interactor to process
     * the request.
     *
     * @param user The user requesting the rate page.
     * @param product The product for which the rate page is being requested.
     */
    public void execute(User user, Product product) throws SQLException, IOException {
        GetRatePageInputData getRatePageInputData = new GetRatePageInputData(user, product);
        getRatePageInteractor.execute(getRatePageInputData);
    }
}
