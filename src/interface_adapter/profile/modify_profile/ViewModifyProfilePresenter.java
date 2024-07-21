package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import use_case.profile.modify_profile.ViewModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileOutputData;

/**
 * Presenter for viewing the modify profile page, responsible for preparing the view model and triggering view updates.
 */
public class ViewModifyProfilePresenter implements ViewModifyProfileOutputBoundary {

    private final ModifyProfileViewModel modifyProfileViewModel;
    private ViewManagerModel viewManagerModel;
    private final UserFactory userFactory;

    /**
     * Constructs a {@link ViewModifyProfilePresenter} with the specified view model, view manager model, and user factory.
     *
     * @param modifyProfileViewModel the view model for modifying the profile
     * @param viewManagerModel the view manager model to manage view changes
     * @param userFactory the factory to create users
     */
    public ViewModifyProfilePresenter(ModifyProfileViewModel modifyProfileViewModel, ViewManagerModel viewManagerModel, UserFactory userFactory) {
        this.modifyProfileViewModel = modifyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
        this.userFactory = userFactory;
    }

    /**
     * Prepares the successful view by updating the modify profile state and triggering property changes.
     *
     * @param response the output data containing the user information
     */
    public void prepareSuccessfulView(ViewModifyProfileOutputData response){
        //ModifyProfileState state = new ModifyProfileState(userFactory);
        ModifyProfileState state = modifyProfileViewModel.getState();
        state.setUser(response.getUser());
        state.setModified(true);

        this.modifyProfileViewModel.setState(state);
        modifyProfileViewModel.firePropertyChanged();
        System.out.println("profile modify prepare successful view " + state.getUser().getName());
        viewManagerModel.setActiveView(modifyProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        state.setModified(false);
    }

    /**
     * Prepares the failed view by updating the modify profile state and triggering property changes.
     *
     * @param response the output data containing the failure message
     */
    public void prepareFailedView(ViewModifyProfileOutputData response){

    }
}
