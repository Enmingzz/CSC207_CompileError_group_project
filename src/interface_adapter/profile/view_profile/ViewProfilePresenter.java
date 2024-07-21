package interface_adapter.profile.view_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.profile.view_profile.ViewProfileOutputData;

/**
 * Presenter for viewing the user's profile, responsible for preparing the view model and triggering view updates.
 */
public class ViewProfilePresenter implements ViewProfileOutputBoundary {

    private final ViewProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a {@link ViewProfilePresenter} with the specified view model and view manager model.
     *
     * @param profileViewModel the view model for viewing the profile
     * @param viewManagerModel the view manager model to manage view changes
     */
    public ViewProfilePresenter(ViewProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the successful view by updating the view profile state and triggering property changes.
     *
     * @param response the output data containing the user information
     */
    @Override
    public void prepareSuccessfulView(ViewProfileOutputData response) {
        ViewProfileState state = profileViewModel.getState();
        state.setUser(response.getUser());
        profileViewModel.setState(state);
        profileViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
