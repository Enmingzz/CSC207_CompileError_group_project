package interface_adapter.main_page;

import interface_adapter.ViewManagerModel;
import use_case.main_page.ShowMainPageOutputData;
import use_case.main_page.ShowMainPageOutputBoundary;
import entity.user.User;

public class MainPagePresenter implements ShowMainPageOutputBoundary {
    private final MainPageViewModel mainPageViewModel;
    private ViewManagerModel viewManagerModel;

    public MainPagePresenter(MainPageViewModel mainPageViewModel,
                             ViewManagerModel viewManagerModel) {
        this.mainPageViewModel = mainPageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ShowMainPageOutputData response) {
        MainPageState mainPageState = mainPageViewModel.getState();
        User user = response.getUser();

        mainPageState.setStudentNumber(user.getStudentNumber());

        mainPageViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(mainPageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
