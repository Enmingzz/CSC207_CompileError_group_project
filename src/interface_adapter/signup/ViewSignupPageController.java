package interface_adapter.signup;

import use_case.signup.ViewSignupPageInputBoundary;
import use_case.signup.ViewSignupPageInputData;

/**
 * Controller class for viewing the signup page.
 * It interacts with the input boundary to execute the action of displaying the signup page.
 */
public class ViewSignupPageController {

    private final ViewSignupPageInputBoundary viewSignupPageInteractor;

    /**
     * Constructs a ViewSignupPageController with the given interactor.
     *
     * @param viewSignupPageInteractor the interactor for viewing the signup page
     */
    public ViewSignupPageController(ViewSignupPageInputBoundary viewSignupPageInteractor) {
        this.viewSignupPageInteractor = viewSignupPageInteractor;
    }

    /**
     * Executes the action of displaying the signup page.
     * Creates an input data object and passes it to the interactor for processing.
     */
    public void execute() {
        ViewSignupPageInputData viewSignupPageInputData = new ViewSignupPageInputData();
        viewSignupPageInteractor.execute(viewSignupPageInputData);
    }

}
