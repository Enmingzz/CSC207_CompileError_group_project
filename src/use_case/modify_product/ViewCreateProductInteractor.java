package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

/**
 * The ViewCreateProductInteractor class is responsible for handling the process of viewing the create product screen.
 * It implements the {@link ViewCreateProductInputBoundary} interface and uses a {@link ViewCreateProductOutputBoundary}
 * to present the result of the operation.
 */
public class ViewCreateProductInteractor implements ViewCreateProductInputBoundary {

    private final ViewCreateProductOutputBoundary viewcreateProductOutputBoundary;

    /**
     * Constructs a ViewCreateProductInteractor instance with the specified output boundary.
     *
     * @param viewcreateProductOutputBoundary the presenter for handling output data and displaying messages
     */
    public ViewCreateProductInteractor(ViewCreateProductOutputBoundary viewcreateProductOutputBoundary) {
        this.viewcreateProductOutputBoundary = viewcreateProductOutputBoundary;
    }

    /**
     * Executes the process of preparing the view for creating a product. It creates an output data object with the user
     * information and informs the presenter to prepare the successful view.
     *
     * @param viewCreateProductInputData the input data required for viewing the create product screen
     */
    public void execute(ViewCreateProductInputData viewCreateProductInputData) {
        ViewCreateProductOutputData viewCreateProductOutputData = new ViewCreateProductOutputData(viewCreateProductInputData.getUser());
        viewcreateProductOutputBoundary.prepareSuccessfulView(viewCreateProductOutputData);
    }
}
