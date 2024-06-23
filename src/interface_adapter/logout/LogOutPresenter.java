package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.main_page.MainPageState;
import interface_adapter.main_page.MainPageViewModel;
import use_case.logout.LogOutOutputBoundary;

public class LogOutPresenter implements LogOutOutputBoundary {
    private final MainPageViewModel mainPageViewModel;
    private final ViewManagerModel viewManagerModel;

    public LogOutPresenter(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel) {
        this.mainPageViewModel = mainPageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView() {
        MainPageState state = mainPageViewModel.getState();
        state.setStudentNumber("");
        mainPageViewModel.firePropertyChanged();
    }
}
