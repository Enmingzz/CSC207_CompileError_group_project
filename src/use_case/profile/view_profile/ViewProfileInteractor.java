package use_case.profile.view_profile;

public class ViewProfileInteractor implements ViewProfileInputBoundary {

    private final ViewProfileOutputBoundary viewProfilePresenter;

    public ViewProfileInteractor(ViewProfileOutputBoundary viewProfilePresenter) {
        this.viewProfilePresenter = viewProfilePresenter;
    }

    public void execute(ViewProfileInputData viewProfileInputData){
        ViewProfileOutputData viewProfileOutputData =
                new ViewProfileOutputData(viewProfileInputData.getUser());
        viewProfilePresenter.prepareSuccessfulView(viewProfileOutputData);
    }

}
