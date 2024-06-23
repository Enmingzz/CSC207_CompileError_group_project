package interface_adapter.login;

import interface_adapter.main_page.MainPageState;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

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
    public void prepareSuccessfulView(LoginOutputData response) {
        LoginState loginState = loginViewModel.getState();
        MainPageState mainPageState = mainPageViewModel.getState();
        mainPageState.setStudentNumber(response.getUser().getStudentNumber());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("test view");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailedView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setStudentNumberError("error");
        loginViewModel.firePropertyChanged();
    }
}
