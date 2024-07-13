package use_case.rate_product;

public class GetRatePageInteractor implements GetRatePageInputBoundary {
    private final GetRatePageOutputBoundary getRatePagePresenter;

    public GetRatePageInteractor(GetRatePageOutputBoundary getRatePagePresenter) {
        this.getRatePagePresenter = getRatePagePresenter;
    }

    @Override
    public void execute(GetRatePageInputData getRatePageInputData) {
        //TODO implement if conditions, such as the state of the product, and also check the user is the one who purchased it (might not be necessary)

        GetRatePageOutputData getRatePageOutputData = new GetRatePageOutputData(getRatePageInputData.getUser(), getRatePageInputData.getProduct());
        getRatePagePresenter.prepareSuccessfulView(getRatePageOutputData);
    }

}
