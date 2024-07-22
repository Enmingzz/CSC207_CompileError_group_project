package interface_adapter.modify_product;

import entity.product.Product;
import entity.user.User;
import use_case.modify_product.DeleteProductInputBoundary;
import use_case.modify_product.DeleteProductInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for handling the deletion of a product.
 *
 * This class serves as the intermediary between the input data for deleting a product and the use case that performs
 * the deletion. It constructs the necessary input data and invokes the corresponding use case to execute the deletion.
 */
public class DeleteProductController {
    private final DeleteProductInputBoundary deleteProductInteractor;

    /**
     * Constructs a new DeleteProductController with the specified DeleteProductInputBoundary.
     *
     * @param deleteProductInteractor The use case boundary for deleting a product.
     */
    public DeleteProductController(DeleteProductInputBoundary deleteProductInteractor) {
        this.deleteProductInteractor = deleteProductInteractor;
    }

    /**
     * Executes the deletion of a product.
     *
     * This method creates an instance of DeleteProductInputData using the provided user and product, then delegates
     * the execution to the DeleteProductInputBoundary.
     *
     * @param user The user requesting the deletion of the product.
     * @param product The product to be deleted.
     * @throws SQLException If a database access error occurs.
     * @throws IOException If an input or output error occurs.
     */
    public void execute(User user, Product product) throws SQLException, IOException {
        DeleteProductInputData deleteProductInputData = new DeleteProductInputData(user, product);
        deleteProductInteractor.execute(deleteProductInputData);
    }
}
