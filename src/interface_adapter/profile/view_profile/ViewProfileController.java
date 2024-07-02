package interface_adapter.profile.view_profile;

import entity.user.User;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInputData;

public class ViewProfileController {

    private final ViewProfileInputBoundary viewProfileInteractor;

    public ViewProfileController(ViewProfileInputBoundary viewProfileInteractor) {
        this.viewProfileInteractor = viewProfileInteractor;
    }

    public void execute(User user){
        ViewProfileInputData viewProfileInputData = new ViewProfileInputData(user);
        viewProfileInteractor.execute(viewProfileInputData);
    }
}
