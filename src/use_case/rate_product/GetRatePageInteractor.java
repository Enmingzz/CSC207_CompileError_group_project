package use_case.rate_product;

/**
 * The GetRatePageInteractor class is responsible for handling the process of retrieving the rating page for a product.
 * It implements the {@link GetRatePageInputBoundary} interface and uses a {@link GetRatePageOutputBoundary}
 * to present the result of the operation.
 */
public class GetRatePageInteractor implements GetRatePageInputBoundary {

    private final GetRatePageOutputBoundary getRatePagePresenter;

    /**
     * Constructs a GetRatePageInteractor instance with the specified output boundary.
     *
     * @param getRatePagePresenter the presenter for handling output data and displaying messages
     */
    public GetRatePageInteractor(GetRatePageOutputBoundary getRatePagePresenter) {
        this.getRatePagePresenter = getRatePagePresenter;
    }

    /**
     * Executes the process of preparing the view for rating a product. It creates an output data object with the user
     * and product information and informs the presenter to prepare the successful view.
     *
     * <p>Note: Conditions such as the state of the product and verifying if the user is the one who purchased it may need
     * to be implemented in the future.</p>
     *
     * @param getRatePageInputData the input data required for viewing the rating page, including the user and product information
     */
    @Override
    public void execute(GetRatePageInputData getRatePageInputData) {

        GetRatePageOutputData getRatePageOutputData = new GetRatePageOutputData(
                getRatePageInputData.getUser(),
                getRatePageInputData.getProduct()
        );
        getRatePagePresenter.prepareSuccessfulView(getRatePageOutputData);
    }
}
