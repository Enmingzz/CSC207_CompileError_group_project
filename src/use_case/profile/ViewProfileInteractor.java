package use_case.profile;

import entity.user.User;

public class ViewProfileInteractor implements ViewProfileInputBoundary {

    private final ViewProfileOutputBoundary viewProfilePresenter;

    public ViewProfileInteractor(ViewProfileOutputBoundary viewProfilePresenter) {
        this.viewProfilePresenter = viewProfilePresenter;
    }

    public void execute(ViewProfileInputData viewProfileInputData){
        ViewProfileOutputData viewProfileOutputData = new ViewProfileOutputData(viewProfileInputData.user);
        viewProfilePresenter.prepareSuccessfulView(viewProfileOutputData);
    }

}
