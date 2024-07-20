package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.signup.SignupState;
import use_case.profile.modify_profile.ModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ModifyProfileOutputData;
import view.profile.ProfileView;

public class ModifyProfilePresenter implements ModifyProfileOutputBoundary {
    private final ModifyProfileViewModel modifyProfileViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ViewProfileViewModel viewProfileViewModel;

    public ModifyProfilePresenter(ModifyProfileViewModel modifyProfileViewModel, ViewProfileViewModel viewProfileViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.modifyProfileViewModel = modifyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
        this.viewProfileViewModel = viewProfileViewModel;
    }

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

    public void prepareFailedView(ModifyProfileOutputData response){
        ModifyProfileState state = modifyProfileViewModel.getState();
        state.setMessage(response.getMessage());

        modifyProfileViewModel.firePropertyChanged();
    }
}
