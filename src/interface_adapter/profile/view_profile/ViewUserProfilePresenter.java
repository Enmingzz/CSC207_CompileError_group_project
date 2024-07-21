package interface_adapter.profile.view_profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.view_profile.ViewUserProfileOutputBoundary;
import use_case.profile.view_profile.ViewUserProfileOutputData;
import view.ViewManager;

public class ViewUserProfilePresenter implements ViewUserProfileOutputBoundary {

    private final ViewUserProfileViewModel viewUserProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewUserProfilePresenter(ViewUserProfileViewModel viewUserProfileViewModel) {
        this.viewUserProfileViewModel = viewUserProfileViewModel;
        this.viewManagerModel = new ViewManagerModel();
    }

    @Override
    public void prepareSuccessfulView(ViewUserProfileOutputData viewUserProfileOutputData) {
        ViewUserProfileState state = viewUserProfileViewModel.getState();
        state.setBuyerUser(viewUserProfileOutputData.getBuyer());
        state.setSellerUser(viewUserProfileOutputData.getSeller());
        state.setListProduct(viewUserProfileOutputData.getProductList());
        viewUserProfileViewModel.setState(state);
        viewUserProfileViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewUserProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
