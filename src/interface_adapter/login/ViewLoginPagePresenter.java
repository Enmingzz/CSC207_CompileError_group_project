package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.login.ViewLoginPageOutputData;

public class ViewLoginPagePresenter implements ViewLoginPageOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewLoginPagePresenter(LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessfulView(ViewLoginPageOutputData viewLoginPageOutputData){
        //TODO need to implement this method
        viewManagerModel.firePropertyChanged();
    }
}
