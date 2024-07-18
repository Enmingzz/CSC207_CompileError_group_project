package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import use_case.profile.modify_profile.ViewModifyProfileOutputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileOutputData;

public class ViewModifyProfilePresenter implements ViewModifyProfileOutputBoundary {

    private final ModifyProfileViewModel modifyProfileViewModel;
    private ViewManagerModel viewManagerModel;
    private final UserFactory userFactory;

    public ViewModifyProfilePresenter(ModifyProfileViewModel modifyProfileViewModel, ViewManagerModel viewManagerModel, UserFactory userFactory) {
        this.modifyProfileViewModel = modifyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
        this.userFactory = userFactory;
    }


    public void prepareSuccessfulView(ViewModifyProfileOutputData response){
        ModifyProfileState state = new ModifyProfileState(userFactory);
        state.setUser(response.getUser());

        this.modifyProfileViewModel.setState(state);
        modifyProfileViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(modifyProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailedView(ViewModifyProfileOutputData response){

    }
}
