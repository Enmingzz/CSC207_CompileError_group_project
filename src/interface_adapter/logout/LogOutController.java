package interface_adapter.logout;

import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInputData;

/**
 * Controller class for the logout process.
 * It interacts with the use case interactor to execute the logout action.
 */
public class LogOutController {

    private final LogOutInputBoundary logOutInteractor;

    /**
     * Constructs a LogOutController with the given interactor.
     *
     * @param logOutInteractor the interactor for the logout use case
     */
    public LogOutController(LogOutInputBoundary logOutInteractor) {
        this.logOutInteractor = logOutInteractor;
    }

    /**
     * Executes the logout process.
     * Creates a logout input data object and passes it to the interactor for processing.
     */
    public void execute() {
        LogOutInputData data = new LogOutInputData();
        logOutInteractor.execute(data);
    }
}
