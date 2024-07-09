package interface_adapter.logout;

import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInputData;

public class LogOutController {

    private final LogOutInputBoundary logOutInteractor;

    public LogOutController(LogOutInputBoundary logOutInteractor) {
        this.logOutInteractor = logOutInteractor;
    }

    public void execute(){
        LogOutInputData data = new LogOutInputData();
        logOutInteractor.execute(data);
    }

}
