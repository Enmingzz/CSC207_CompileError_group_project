package use_case.logout;

/**
 * Interactor class for the logout process.
 * Implements the LogOutInputBoundary interface to handle the action of logging out.
 */

public class LogOutInteractor implements LogOutInputBoundary {

    private final LogOutOutputBoundary logOutPresenter;

    /**
     * Constructs a LogOutInteractor with the given presenter.
     *
     * @param logOutPresenter the presenter for the logout process
     */

    public LogOutInteractor(LogOutOutputBoundary logOutPresenter) {
        this.logOutPresenter = logOutPresenter;
    }

    /**
     * Executes the logout process.
     * Creates an output data object and passes it to the presenter to prepare the successful view.
     *
     * @param logOutInputData the input data for the logout process
     */
    @Override
    public void execute(LogOutInputData logOutInputData) {
        LogOutOutputData logOutOutputData = new LogOutOutputData();
        logOutPresenter.prepareSuccessfulView(logOutOutputData);
    }
}
