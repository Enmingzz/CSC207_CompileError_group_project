package interface_adapter.profile.view_profile;

import entity.user.User;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInputData;

/**
 * Controller for viewing the user's profile, responsible for handling user interactions and invoking the use case.
 */
public class ViewProfileController {

    private final ViewProfileInputBoundary viewProfileInteractor;

    /**
     * Constructs a {@link ViewProfileController} with the specified interactor.
     *
     * @param viewProfileInteractor the interactor to handle the view profile logic
     */
    public ViewProfileController(ViewProfileInputBoundary viewProfileInteractor) {
        this.viewProfileInteractor = viewProfileInteractor;
    }

    /**
     * Executes the view profile use case for the specified user.
     *
     * @param user the user whose profile is to be viewed
     */
    public void execute(User user) {
        ViewProfileInputData viewProfileInputData = new ViewProfileInputData(user);
        viewProfileInteractor.execute(viewProfileInputData);
    }
}