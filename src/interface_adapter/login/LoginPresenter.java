package interface_adapter.login;

import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final MainPageViewModel mainPageViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) {
        this.loginViewModel = loginViewModel;
        this.mainPageViewModel = mainPageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView() {

    }

    @Override
    public void prepareFailedView() {

    }
}
