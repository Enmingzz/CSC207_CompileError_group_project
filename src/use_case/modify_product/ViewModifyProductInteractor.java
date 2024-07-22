package use_case.modify_product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The ViewModifyProductInteractor class is responsible for handling the process of viewing the modify product screen.
 * It implements the {@link ViewModifyProductInputBoundary} interface and uses a {@link ViewModifyProductOutputBoundary}
 * to present the result of the operation.
 */
public class ViewModifyProductInteractor implements ViewModifyProductInputBoundary {

    private final ViewModifyProductOutputBoundary viewModifyProductOutputBoundary;

    /**
     * Constructs a ViewModifyProductInteractor instance with the specified output boundary.
     *
     * @param viewModifyProductOutputBoundary the presenter for handling output data and displaying messages
     */
    public ViewModifyProductInteractor(ViewModifyProductOutputBoundary viewModifyProductOutputBoundary) {
        this.viewModifyProductOutputBoundary = viewModifyProductOutputBoundary;
    }

    /**
     * Executes the process of preparing the view for modifying a product. It creates an output data object with the user
     * and product information, and informs the presenter to prepare the successful view.
     *
     * @param viewModifyProductInputData the input data required for viewing the modify product screen, including the user and product information
     */
    public void execute(ViewModifyProductInputData viewModifyProductInputData) throws SQLException, IOException {
        ViewModifyProductOutputData viewModifyProductOutputData = new ViewModifyProductOutputData(
                viewModifyProductInputData.getUser(),
                viewModifyProductInputData.getProduct()
        );
        viewModifyProductOutputBoundary.prepareSuccessfulView(viewModifyProductOutputData);
    }
}
