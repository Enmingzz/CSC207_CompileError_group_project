package interface_adapter.modify_product;

import entity.product.Product;
import entity.user.User;
import use_case.modify_product.ChangeProductInputBoundary;
import use_case.modify_product.ChangeProductInputData;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for managing the modification of product details.
 *
 * This class coordinates the interaction between the view and the use case for modifying product information.
 * It collects data from the view, creates an input data object, and passes it to the use case for processing.
 */
public class ModifyProductController {
    private final ChangeProductInputBoundary changeProductInputInteractor;

    /**
     * Constructs a new ModifyProductController with the specified ChangeProductInputBoundary.
     *
     * @param changeProductInputInteractor The input boundary used for executing the product modification use case.
     */
    public ModifyProductController(ChangeProductInputBoundary changeProductInputInteractor) {
        this.changeProductInputInteractor = changeProductInputInteractor;
    }

    /**
     * Executes the product modification use case with the given product details.
     *
     * This method creates a ChangeProductInputData object with the provided product and modification details,
     * and then passes it to the changeProductInputInteractor for processing.
     *
     * @param user The user performing the modification.
     * @param product The product to be modified.
     * @param changedDescription The new description for the product.
     * @param changedPrice The new price for the product.
     * @param address The new address associated with the product.
     * @param title The new title of the product.
     * @param email The new email associated with the product.
     * @param image The new image for the product.
     * @throws SQLException If a database access error occurs.
     * @throws IOException If an I/O error occurs.
     */
    public void execute(User user, Product product, String changedDescription, String changedPrice,
                        String address, String title, String email, Image image) throws SQLException, IOException {

        ChangeProductInputData changeProductInputData = new ChangeProductInputData(user, product,
                changedDescription, changedPrice, address, title, email, image);

        changeProductInputInteractor.execute(changeProductInputData);
    }
}
