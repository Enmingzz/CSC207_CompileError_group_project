package interface_adapter.rating;

import interface_adapter.ViewManagerModel;
import use_case.rate_product.GetRatePageOutputBoundary;
import use_case.rate_product.GetRatePageOutputData;

/**
 * Presenter for handling the output of the request to get the rate page for a product.
 *
 * This class is responsible for updating the view model with the output data from
 * the use case and managing the view transitions. It prepares the view state
 * with the provided user and product information and updates the view manager.
 */
public class GetRatePagePresenter implements GetRatePageOutputBoundary {
    private final RateProductViewModel rateProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a GetRatePagePresenter with the specified view model and view manager.
     *
     * @param rateProductViewModel The view model for the rate product view.
     * @param viewManagerModel The manager responsible for view transitions.
     */
    public GetRatePagePresenter(RateProductViewModel rateProductViewModel, ViewManagerModel viewManagerModel) {
        this.rateProductViewModel = rateProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for the rate product page using the provided output data.
     *
     * This method updates the view model with the user and product information
     * from the GetRatePageOutputData. It then triggers a property change event
     * on the view model and sets the active view in the view manager.
     *
     * @param getRatePageOutputData The output data containing the user and product information.
     */
    @Override
    public void prepareSuccessfulView(GetRatePageOutputData getRatePageOutputData) {
        System.out.println("rate product page presenter requested");
        RateProductState state = rateProductViewModel.getState();

        state.setUser(getRatePageOutputData.getUser());
        state.setProduct(getRatePageOutputData.getProduct());

        rateProductViewModel.setState(state);
        rateProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(rateProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
