package interface_adapter.login;

import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInputData;

/**
 * Controller class for viewing the login page.
 * It interacts with the input boundary to execute the action of displaying the login page.
 */
public class ViewLoginPageController {

    private final ViewLoginPageInputBoundary viewLoginPageInteractor;

    /**
     * Constructs a ViewLoginPageController with the given interactor.
     *
     * @param viewLoginPageInteractor the interactor for viewing the login page
     */
    public ViewLoginPageController(ViewLoginPageInputBoundary viewLoginPageInteractor) {
        this.viewLoginPageInteractor = viewLoginPageInteractor;
    }

    /**
     * Executes the action of displaying the login page.
     * Creates an input data object and passes it to the interactor for processing.
     */
    public void execute() {
        ViewLoginPageInputData inputData = new ViewLoginPageInputData();
        viewLoginPageInteractor.execute(inputData);
    }
}
