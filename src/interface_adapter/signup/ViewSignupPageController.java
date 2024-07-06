package interface_adapter.signup;

import use_case.Signup.ViewSignupPageInputBoundary;
import use_case.Signup.ViewSignupPageInputData;

public class ViewSignupPageController {

    private final ViewSignupPageInputBoundary viewSignupPageInteractor;


    public ViewSignupPageController(ViewSignupPageInputBoundary viewSignupPageInteractor) {
        this.viewSignupPageInteractor = viewSignupPageInteractor;
    }

    public void execute(){
        ViewSignupPageInputData viewSignupPageInputData = new ViewSignupPageInputData();
        viewSignupPageInteractor.execute(viewSignupPageInputData);
    }

}
