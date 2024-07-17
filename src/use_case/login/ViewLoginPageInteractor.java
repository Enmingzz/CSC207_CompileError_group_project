package use_case.login;

/**
 * Interactor class for displaying the login page.
 * Implements the ViewLoginPageInputBoundary interface to handle the action of showing the login page.
 */

public class ViewLoginPageInteractor implements ViewLoginPageInputBoundary {

    private final ViewLoginPageOutputBoundary presenter;

    /**
     * Constructs a ViewLoginPageInteractor with the given presenter.
     *
     * @param presenter the presenter for displaying the login page
     */

    public ViewLoginPageInteractor(ViewLoginPageOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Executes the action of displaying the login page.
     * Creates an output data object and passes it to the presenter to prepare the successful view.
     *
     * @param inputData the input data for displaying the login page
     */

    @Override
    public void execute(ViewLoginPageInputData inputData) {
        ViewLoginPageOutputData viewLoginPageOutputData = new ViewLoginPageOutputData();
        presenter.prepareSuccessfulView(viewLoginPageOutputData);
    }
}
