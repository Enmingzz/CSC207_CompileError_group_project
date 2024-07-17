package use_case.profile.modify_profile;

/**
 * Interface for the presenter of modifying profiles.
 * Provides methods to prepare the view for successful and failed profile modification operations.
 */
public interface ModifyProfileOutputBoundary {

    /**
     * Prepares the view for a successful profile modification operation.
     *
     * @param modifyProfileOutputData the output data for the successful profile modification
     */
    void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData);

    /**
     * Prepares the view for a failed profile modification operation.
     *
     * @param modifyProfileOutputData the output data for the failed profile modification
     */
    void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData);
}
