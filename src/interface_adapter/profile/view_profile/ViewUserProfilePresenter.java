package interface_adapter.profile.view_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.view_profile.ViewUserProfileOutputBoundary;
import use_case.profile.view_profile.ViewUserProfileOutputData;
import view.ViewManager;
/**
 * Presenter for viewing another user's profile, responsible for preparing the view model and triggering view updates.
 */
public class ViewUserProfilePresenter implements ViewUserProfileOutputBoundary {

    private final ViewUserProfileViewModel viewUserProfileViewModel;
    private final ViewManagerModel viewManagerModel;
    /**
     * Constructs a {@link ViewUserProfilePresenter} with the specified view model.
     *
     * @param viewUserProfileViewModel the view model for viewing the user profile
     */
    public ViewUserProfilePresenter(ViewUserProfileViewModel viewUserProfileViewModel) {
        this.viewUserProfileViewModel = viewUserProfileViewModel;
        this.viewManagerModel = new ViewManagerModel();
    }
    /**
     * Prepares the successful view by updating the view user profile state and triggering property changes.
     *
     * @param viewUserProfileOutputData the output data containing the buyer, seller, and product list
     */
    @Override
    public void prepareSuccessfulView(ViewUserProfileOutputData viewUserProfileOutputData) {
        ViewUserProfileState state = viewUserProfileViewModel.getState();
        state.setBuyerUser(viewUserProfileOutputData.getBuyer());
        state.setSellerUser(viewUserProfileOutputData.getSeller());
        state.setListProduct(viewUserProfileOutputData.getProductList());
        viewUserProfileViewModel.setState(state);
        viewUserProfileViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewUserProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
