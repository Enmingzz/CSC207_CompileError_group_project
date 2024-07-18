package use_case.profile.manage_product;

/**
 * Interface for the presenter of managing products.
 * Provides a method to prepare the view for a successful product management operation.
 */

public interface ManageProductOutputBoundary {

    /**
     * Prepares the view for a successful product management operation.
     *
     * @param manageProductOutputData the output data for managing products
     */
    void prepareSuccessfulView(ManageProductOutputData manageProductOutputData);
}
