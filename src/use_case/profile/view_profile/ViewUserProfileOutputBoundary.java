package use_case.profile.view_profile;

/**
 * Output boundary interface for viewing a user's profile use case.
 * This interface defines the method to prepare the view of a successful user profile retrieval.
 */
public interface ViewUserProfileOutputBoundary {

    /**
     * Prepares the view for a successful user profile retrieval.
     *
     * @param viewUserProfileOutputData the output data containing the seller's profile and associated products
     */
    void prepareSuccessfulView(ViewUserProfileOutputData viewUserProfileOutputData);
}
