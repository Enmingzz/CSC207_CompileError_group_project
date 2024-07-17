package interface_adapter.profile.modify_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.modify_profile.ModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ModifyProfileOutputData;

public class ModifyProfilePresenter implements ModifyProfileOutputBoundary {
//    private final ModifyProfileViewModel modifyProfileViewModel;
//    private final ViewManagerModel viewManagerModel;

    public ModifyProfilePresenter(ModifyProfileViewModel modifyProfileViewModel, ViewManagerModel viewManagerModel) {
//        this.modifyProfileViewModel = modifyProfileViewModel;
//        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessfulView(ModifyProfileOutputData response){
//        ModifyProfileState state = modifyProfileViewModel.getState();
//        state.setMessage(response.getMessage());
//        modifyProfileViewModel.setState(state);
//        modifyProfileViewModel.firePropertyChanged();
    }

    public void prepareFailedView(ModifyProfileOutputData response){
//        ModifyProfileState state = modifyProfileViewModel.getState();
//        state.setMessage(response.getMessage());
//        modifyProfileViewModel.setState(state);
//        modifyProfileViewModel.firePropertyChanged();
    }
}
