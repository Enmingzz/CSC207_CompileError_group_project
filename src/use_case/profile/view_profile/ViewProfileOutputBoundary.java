package use_case.profile.view_profile;

/**
 * Interface for the presenter of viewing the profile.
 * Provides a method to prepare the view for a successful display of the profile.
 */
public interface ViewProfileOutputBoundary {

    /**
     * Prepares the view for a successful display of the profile.
     *
     * @param viewProfileOutputData the output data for displaying the profile
     */
    void prepareSuccessfulView(ViewProfileOutputData viewProfileOutputData);
}
