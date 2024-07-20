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

    public void prepareFailedView(ViewModifyProfileOutputData response){

    }
}
