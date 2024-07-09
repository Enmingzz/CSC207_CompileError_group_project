package interface_adapter.schedule;


import interface_adapter.ViewManagerModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import use_case.schedule.SellerSelectScheduleOutputBoundary;
import use_case.schedule.SellerSelectScheduleOutputData;

public class SellerSelectSchedulePresenter implements SellerSelectScheduleOutputBoundary {
    private SellerSelectScheduleViewModel viewModel;
    private ViewProfileViewModel profileViewModel;
    private ViewManagerModel viewManagerModel;


    public SellerSelectSchedulePresenter(SellerSelectScheduleViewModel viewModel,
                                         ViewProfileViewModel profileViewModel,
                                         ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentScheduleSelection(SellerSelectScheduleOutputData outputData) {
        //move to profile view
        viewManagerModel.setActiveView(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
