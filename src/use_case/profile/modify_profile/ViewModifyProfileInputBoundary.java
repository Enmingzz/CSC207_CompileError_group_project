package use_case.profile.modify_profile;

/**
 * Interface for viewing the modify profile page.
 * Provides a method to execute the action of displaying the modify profile page.
 */
public interface ViewModifyProfileInputBoundary {

    /**
     * Executes the action of displaying the modify profile page.
     *
     * @param viewModifyProfileInputData the input data for viewing the modify profile page
     */
    void execute(ViewModifyProfileInputData viewModifyProfileInputData);

}
