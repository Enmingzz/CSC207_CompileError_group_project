package use_case.modify_product;

import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interactor class responsible for handling the deletion of a product. It interacts with the data access layer to
 * delete the product and prepares the output data for the presenter.
 */
public class DeleteProductInteractor implements DeleteProductInputBoundary {
    private final DeleteProductOutputBoundary deleteProductOutputBoundary;
    private final ProductDeleteDataAccessByIDInterface productDeleteDataAccessByIDInterface;

    /**
     * Constructs a DeleteProductInteractor instance with the specified output boundary and data access interface.
     *
     * @param deleteProductOutputBoundary the presenter for handling output data
     * @param productDeleteDataAccessByIDInterface the data access interface for deleting the product by ID
     */
    public DeleteProductInteractor(DeleteProductOutputBoundary deleteProductOutputBoundary,
                                   ProductDeleteDataAccessByIDInterface productDeleteDataAccessByIDInterface) {
        this.deleteProductOutputBoundary = deleteProductOutputBoundary;
        this.productDeleteDataAccessByIDInterface = productDeleteDataAccessByIDInterface;
    }

    /**
     * Executes the process of deleting a product. It deletes the product using the data access interface and prepares
     * the output data for the presenter.
     *
     * @param deleteProductInputData the input data for deleting the product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(DeleteProductInputData deleteProductInputData) throws SQLException, IOException {
        // Uses the interface to delete the product from the database
        productDeleteDataAccessByIDInterface.deleteProductByID(deleteProductInputData.getProduct().getProductID());

        DeleteProductOutputData deleteProductOutputData = new DeleteProductOutputData(deleteProductInputData.getUser(), deleteProductInputData.getProduct());
        deleteProductOutputBoundary.prepareSuccessfulView(deleteProductOutputData);
    }
}
