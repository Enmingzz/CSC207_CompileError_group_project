package use_case.modify_product;

/**
 * Interface for the output boundary of the delete product use case.
 * This interface defines the methods required to handle the output of a product deletion process.
 */
public interface DeleteProductOutputBoundary {

    /**
     * Prepares the view for a successful product deletion.
     * This method is called when the product has been successfully deleted.
     *
     * @param deleteProductOutputData the data containing the result of the product deletion
     */
    public void prepareSuccessfulView(DeleteProductOutputData deleteProductOutputData);
}
