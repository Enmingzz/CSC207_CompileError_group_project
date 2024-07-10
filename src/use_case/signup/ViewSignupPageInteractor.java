package use_case.signup;

public class ViewSignupPageInteractor implements ViewSignupPageInputBoundary{

    private final ViewSignupPageOutputBoundary viewSignupPresenter;

    public ViewSignupPageInteractor(ViewSignupPageOutputBoundary viewSignupPresenter) {
        this.viewSignupPresenter = viewSignupPresenter;
    }

    @Override

    public void execute(ViewSignupPageInputData viewSignupPageData){
        ViewSignupPageOutputData viewSignupPageOutputData = new ViewSignupPageOutputData();
        viewSignupPresenter.prepareSuccessfulView(viewSignupPageOutputData);
    }

}
