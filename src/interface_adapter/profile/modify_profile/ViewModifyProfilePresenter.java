package interface_adapter.profile.modify_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.modify_profile.ViewModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileOutputData;

public class ViewModifyProfilePresenter implements ViewModifyProfileOutputBoundary {

    private final ModifyProfileViewModel modifyProfileViewModel;
    private ViewManagerModel viewManagerModel;

    public ViewModifyProfilePresenter(ModifyProfileViewModel modifyProfileViewModel, ViewManagerModel viewManagerModel) {
        this.modifyProfileViewModel = modifyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    public void prepareSuccessfulView(ViewModifyProfileOutputData response){
        ModifyProfileState state = new ModifyProfileState(response.getUser());

        this.modifyProfileViewModel.setState(state);
        modifyProfileViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(modifyProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailedView(ViewModifyProfileOutputData response){

    }
}
