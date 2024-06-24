package use_case.logout;

import interface_adapter.main_page.MainPageViewModel;

public class LogOutInteractor implements LogOutInputBoundary{

    private final LogOutOutputBoundary logOutPresenter;

    public LogOutInteractor(LogOutOutputBoundary logOutPresenter) {
        this.logOutPresenter = logOutPresenter;
    }

    public void execute(){

    }
}
