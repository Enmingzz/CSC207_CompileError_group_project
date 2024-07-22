package interface_adapter.profile.view_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.view_profile.ViewUserProfileOutputBoundary;
import use_case.profile.view_profile.ViewUserProfileOutputData;
import view.ViewManager;

/**
 * Presenter class for the view user profile use case.
 * This class handles the presentation logic and updates the view model and view manager model accordingly.
 */
public class ViewUserProfilePresenter implements ViewUserProfileOutputBoundary {

    private final ViewUserProfileViewModel viewUserProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewUserProfilePresenter with the specified view model and view manager model.
     *
     * @param viewUserProfileViewModel the view model for the user profile
     * @param viewManagerModel the view manager model for managing views
     */
    public ViewUserProfilePresenter(ViewUserProfileViewModel viewUserProfileViewModel, ViewManagerModel viewManagerModel) {
        this.viewUserProfileViewModel = viewUserProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful user profile retrieval.
     * Updates the view model with the user profile data and sets the active view.
     *
     * @param viewUserProfileOutputData the output data containing the seller's profile, buyer's information, and product list
     */
    @Override
    public void prepareSuccessfulView(ViewUserProfileOutputData viewUserProfileOutputData) {
        System.out.println("ViewUserProfilePresenter prepareSuccessfulView");
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
