package interface_adapter.rating;

import use_case.rate_product.GetRatePageOutputBoundary;
import use_case.rate_product.GetRatePageOutputData;

public class GetRatePagePresenter implements GetRatePageOutputBoundary {
    private final RateProductViewModel rateProductViewModel;

    public GetRatePagePresenter(RateProductViewModel rateProductViewModel) {
        this.rateProductViewModel = rateProductViewModel;
    }

    public void prepareSuccessfulView(GetRatePageOutputData getRatePageOutputData){
        RateProductState state = rateProductViewModel.getState();
        rateProductViewModel.setState(state);
        rateProductViewModel.firePropertyChanged();
    }

}
