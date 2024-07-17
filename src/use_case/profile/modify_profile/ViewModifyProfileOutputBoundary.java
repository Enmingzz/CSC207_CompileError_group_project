package use_case.profile.modify_profile;

/**
 * Interface for the presenter of viewing the modify profile page.
 * Provides a method to prepare the view for a successful display of the modify profile page.
 */

public interface ViewModifyProfileOutputBoundary {

    /**
     * Prepares the view for a successful display of the modify profile page.
     *
     * @param viewModifyProfileOutputData the output data for displaying the modify profile page
     */
    void prepareSuccessfulView(ViewModifyProfileOutputData viewModifyProfileOutputData);

}
