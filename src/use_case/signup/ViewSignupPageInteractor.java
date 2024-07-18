package use_case.signup;

/**
 * Interactor class for viewing the signup page.
 * Implements the ViewSignupPageInputBoundary interface to handle the action of displaying the signup page.
 */
public class ViewSignupPageInteractor implements ViewSignupPageInputBoundary {

    private final ViewSignupPageOutputBoundary viewSignupPresenter;

    /**
     * Constructs a ViewSignupPageInteractor with the given presenter.
     *
     * @param viewSignupPresenter the presenter for displaying the signup page
     */
    public ViewSignupPageInteractor(ViewSignupPageOutputBoundary viewSignupPresenter) {
        this.viewSignupPresenter = viewSignupPresenter;
    }

    /**
     * Executes the action of displaying the signup page.
     * Creates an output data object and passes it to the presenter to prepare the successful view.
     *
     * @param viewSignupPageData the input data for viewing the signup page
     */
    @Override
    public void execute(ViewSignupPageInputData viewSignupPageData) {
        ViewSignupPageOutputData viewSignupPageOutputData = new ViewSignupPageOutputData();
        viewSignupPresenter.prepareSuccessfulView(viewSignupPageOutputData);
    }
}
