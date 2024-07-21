package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.signup.SignupState;
import use_case.profile.modify_profile.ModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ModifyProfileOutputData;
import view.profile.ProfileView;

/**
 * Presenter for modifying the user's profile, responsible for preparing the view models and triggering view updates.
 */

public class ModifyProfilePresenter implements ModifyProfileOutputBoundary {
    private final ModifyProfileViewModel modifyProfileViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ViewProfileViewModel viewProfileViewModel;

    /**
     * Constructs a {@link ModifyProfilePresenter} with the specified view models and view manager model.
     *
     * @param modifyProfileViewModel the view model for modifying the profile
     * @param viewProfileViewModel the view model for viewing the profile
     * @param viewManagerModel the view manager model to manage view changes
     */
    public ModifyProfilePresenter(ModifyProfileViewModel modifyProfileViewModel, ViewProfileViewModel viewProfileViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.modifyProfileViewModel = modifyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
        this.viewProfileViewModel = viewProfileViewModel;
    }

    /**
     * Prepares the successful view by updating the modify profile and view profile states and triggering property changes.
     *
     * @param response the output data containing the success message
     */
    public void prepareSuccessfulView(ModifyProfileOutputData response){
        ViewProfileState viewProfileState = new ViewProfileState(modifyProfileViewModel.getState().getUser());
        ModifyProfileState modifyProfileState = new ModifyProfileState(new CommonUserFactory());

//        viewProfileState.setMessage(response.getMessage());
        modifyProfileState.setMessage(response.getMessage());

        modifyProfileViewModel.setState(modifyProfileState);
        viewProfileViewModel.setState(viewProfileState);

        modifyProfileViewModel.firePropertyChanged();
        viewProfileViewModel.firePropertyChanged();
        modifyProfileViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(viewProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failed view by updating the modify profile state and triggering property changes.
     *
     * @param response the output data containing the failure message
     */
    public void prepareFailedView(ModifyProfileOutputData response){
        ModifyProfileState state = modifyProfileViewModel.getState();
        state.setMessage(response.getMessage());

        modifyProfileViewModel.firePropertyChanged();
    }
}
