package interface_adapter.login;

import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInputData;

public class ViewLoginPageController {

    private final ViewLoginPageInputBoundary viewLoginPageInteractor;

    public ViewLoginPageController(ViewLoginPageInputBoundary viewLoginPageInteractor) {
        this.viewLoginPageInteractor = viewLoginPageInteractor;
    }

    public void execute(){
        ViewLoginPageInputData inputData = new ViewLoginPageInputData();
        viewLoginPageInteractor.execute(inputData);
    }
}
