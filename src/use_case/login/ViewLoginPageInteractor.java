package use_case.login;

import interface_adapter.login.ViewLoginPagePresenter;

public class ViewLoginPageInteractor implements ViewLoginPageInputBoundary{

    private final ViewLoginPageOutputBoundary presenter;

    public ViewLoginPageInteractor(ViewLoginPageOutputBoundary presenter) {
        this.presenter = presenter;
    }

    public void execute(ViewLoginPageInputData inputData){
        ViewLoginPageOutputData viewLoginPageOutputData = new ViewLoginPageOutputData();
        presenter.prepareSuccessfulView(viewLoginPageOutputData);
    }



}
