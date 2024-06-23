package interface_adapter.logout;

import use_case.logout.LogOutInputBoundary;

public class LogOutController {

    private final LogOutInputBoundary logOutInteractor;

    public LogOutController(LogOutInputBoundary logOutInteractor) {
        this.logOutInteractor = logOutInteractor;
    }

    public void execute(){
        logOutInteractor.execute();
    }
}
