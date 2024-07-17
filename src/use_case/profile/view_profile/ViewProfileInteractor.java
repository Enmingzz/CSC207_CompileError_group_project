package use_case.profile.view_profile;

/**
 * Interactor class for viewing the profile.
 * Implements the ViewProfileInputBoundary interface to handle the action of displaying the profile.
 */

public class ViewProfileInteractor implements ViewProfileInputBoundary {

    private final ViewProfileOutputBoundary viewProfilePresenter;

    /**
     * Constructs a ViewProfileInteractor with the given presenter.
     *
     * @param viewProfilePresenter the presenter for displaying the profile
     */

    public ViewProfileInteractor(ViewProfileOutputBoundary viewProfilePresenter) {
        this.viewProfilePresenter = viewProfilePresenter;
    }

    /**
     * Executes the action of displaying the profile.
     * Creates an output data object with the user information and passes it to the presenter.
     *
     * @param viewProfileInputData the input data for viewing the profile
     */
    @Override
    public void execute(ViewProfileInputData viewProfileInputData) {
        ViewProfileOutputData viewProfileOutputData =
                new ViewProfileOutputData(viewProfileInputData.getUser());
        viewProfilePresenter.prepareSuccessfulView(viewProfileOutputData);
    }
}
