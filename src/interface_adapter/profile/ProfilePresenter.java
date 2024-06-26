package interface_adapter.profile;

import entity.user.User;
import use_case.profile.ViewProfileOutputBoundary;
import use_case.profile.ViewProfileOutputData;

public class ProfilePresenter implements ViewProfileOutputBoundary {

    private final ProfileViewModel profileViewModel;

    public ProfilePresenter(ProfileViewModel profileViewModel) {
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void prepareSuccessfulView(ViewProfileOutputData response) {
        ProfileState state = profileViewModel.getState();
        state.setUser(response.getUser());
        profileViewModel.setState(state);
        profileViewModel.firePropertyChanged();
    }

}
