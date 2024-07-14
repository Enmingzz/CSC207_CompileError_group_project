package interface_adapter.profile.modify_profile;

import use_case.profile.modify_profile.ViewModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileOutputData;

public class ViewModifyProfilePresenter implements ViewModifyProfileOutputBoundary {

    private final ModifyProfileViewModel modifyProfileViewModel;

    public ViewModifyProfilePresenter(interface_adapter.profile.modify_profile.ModifyProfileViewModel modifyProfileViewModel) {
        this.modifyProfileViewModel = modifyProfileViewModel;
    }


    public void prepareSuccessfulView(ViewModifyProfileOutputData response){
        ModifyProfileState state = modifyProfileViewModel.getState();
        
    }

    public void prepareFailedView(ViewModifyProfileOutputData response){

    }
}
