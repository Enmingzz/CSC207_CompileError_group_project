package interface_adapter.profile;

import entity.user.User;
import use_case.profile.ViewProfileInputBoundary;
import use_case.profile.ViewProfileInputData;

public class ProfileController {

    private final ViewProfileInputBoundary viewProfilePresenter;

    public ProfileController(ViewProfileInputBoundary viewProfilePresenter) {
        this.viewProfilePresenter = viewProfilePresenter;
    }

    public void execute(User user){
        ViewProfileInputData viewProfileInputData = new ViewProfileInputData(user);
        viewProfilePresenter.execute(viewProfileInputData);
    }
}
