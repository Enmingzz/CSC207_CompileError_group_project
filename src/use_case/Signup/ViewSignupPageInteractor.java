package use_case.Signup;

public class ViewSignupPageInteractor implements ViewSignupPageInputBoundary{

    private final ViewSignupPageOutputBoundary viewSignupPresenter;

    public ViewSignupPageInteractor(ViewSignupPageOutputBoundary viewSignupPresenter) {
        this.viewSignupPresenter = viewSignupPresenter;
    }


    void execute(ViewSignupPageInputBoundary viewSignupPageData){
        ViewSignupPageOutputData viewSignupPageOutputData = new ViewSignupPageOutputData();
        viewSignupPresenter.prepareSuccessfulView(viewSignupPageOutputData);
    }
}
