package interface_adapter.profile.view_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.profile.view_profile.ViewProfileOutputData;

public class ViewProfilePresenter implements ViewProfileOutputBoundary {

    private final ViewProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewProfilePresenter(ViewProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(ViewProfileOutputData response) {
        ViewProfileState state = profileViewModel.getState();
        state.setUser(response.getUser());
        profileViewModel.setState(state);
        profileViewModel.firePropertyChanged();
    }

}
