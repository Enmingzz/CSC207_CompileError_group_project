package use_case.logout;

import interface_adapter.main_page.MainPageViewModel;

public class LogOutInteractor {

    private final LogOutInteractor logOutPresenter;

    public LogOutInteractor(LogOutInteractor logOutPresenter) {
        this.logOutPresenter = logOutPresenter;
    }
}
