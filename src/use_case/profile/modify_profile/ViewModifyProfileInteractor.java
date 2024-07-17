package use_case.profile.modify_profile;

/**
 * Interactor class for viewing the modify profile page.
 * Implements the ViewModifyProfileInputBoundary interface to handle the action of displaying the modify profile page.
 */

public class ViewModifyProfileInteractor implements ViewModifyProfileInputBoundary {

    private final ViewModifyProfileOutputBoundary viewModifyProfilePresenter;

    /**
     * Constructs a ViewModifyProfileInteractor with the given presenter.
     *
     * @param viewModifyProfilePresenter the presenter for displaying the modify profile page
     */
    public ViewModifyProfileInteractor(ViewModifyProfileOutputBoundary viewModifyProfilePresenter) {
        this.viewModifyProfilePresenter = viewModifyProfilePresenter;
    }

    /**
     * Executes the action of displaying the modify profile page.
     * Creates an output data object with the user information and passes it to the presenter.
     *
     * @param viewModifyProfileInputData the input data for viewing the modify profile page
     */
    @Override
    public void execute(ViewModifyProfileInputData viewModifyProfileInputData) {
        ViewModifyProfileOutputData viewModifyProfileOutputData =
                new ViewModifyProfileOutputData(viewModifyProfileInputData.getUser());
        viewModifyProfilePresenter.prepareSuccessfulView(viewModifyProfileOutputData);
    }
}
