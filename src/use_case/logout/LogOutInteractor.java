package use_case.logout;

public class LogOutInteractor implements LogOutInputBoundary{

    private final LogOutOutputBoundary logOutPresenter;

    public LogOutInteractor(LogOutOutputBoundary logOutPresenter) {
        this.logOutPresenter = logOutPresenter;
    }

    public void execute(){

    }
}
