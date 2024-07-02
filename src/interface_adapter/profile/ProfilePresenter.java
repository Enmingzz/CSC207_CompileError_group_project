package interface_adapter.profile;

import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.profile.ViewProfileOutputBoundary;
import use_case.profile.ViewProfileOutputData;

public class ProfilePresenter implements ViewProfileOutputBoundary {

    private final ProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ProfilePresenter(ProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(ViewProfileOutputData response) {
        ProfileState state = profileViewModel.getState();
        state.setUser(response.getUser());
        profileViewModel.setState(state);
        profileViewModel.firePropertyChanged();
    }

}
