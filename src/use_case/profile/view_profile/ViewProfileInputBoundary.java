package use_case.profile.view_profile;

/**
 * Interface for viewing the profile.
 * Provides a method to execute the action of displaying the profile.
 */

public interface ViewProfileInputBoundary {

    /**
     * Executes the action of displaying the profile.
     *
     * @param viewProfileInputData the input data for viewing the profile
     */
    void execute(ViewProfileInputData viewProfileInputData);
}
