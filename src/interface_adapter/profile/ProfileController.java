package interface_adapter.profile;

import entity.user.User;
import use_case.profile.ViewProfileInputBoundary;
import use_case.profile.ViewProfileInputData;

public class ProfileController {

    private final ViewProfileInputBoundary viewProfileInteractor;

    public ProfileController(ViewProfileInputBoundary viewProfileInteractor) {
        this.viewProfileInteractor = viewProfileInteractor;
    }

    public void execute(User user){
        ViewProfileInputData viewProfileInputData = new ViewProfileInputData(user);
        viewProfileInteractor.execute(viewProfileInputData);
    }
}
