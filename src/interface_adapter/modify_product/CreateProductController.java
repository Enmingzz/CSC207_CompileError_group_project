package interface_adapter.modify_product;

import entity.user.User;
import use_case.modify_product.CreateProductInputBoundary;
import use_case.modify_product.CreateProductInputData;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Controller responsible for handling requests to create a new product.
 *
 * This controller interacts with the use case layer to process the creation of a new product
 * by converting user inputs into the appropriate input data format and passing it to the
 * `CreateProductInputBoundary` for execution.
 */
public class CreateProductController {

    private final CreateProductInputBoundary createProductInteractor;

    /**
     * Constructs a new CreateProductController instance.
     *
     * @param createProductInteractor The use case boundary for creating a product.
     */
    public CreateProductController(CreateProductInputBoundary createProductInteractor) {
        this.createProductInteractor = createProductInteractor;
    }

    /**
     * Executes the process of creating a new product.
     *
     * This method creates an instance of `CreateProductInputData` using the provided parameters
     * and delegates the execution to the `CreateProductInputBoundary`.
     *
     * @param user          The user who is creating the product.
     * @param image         The image of the product.
     * @param description   The description of the product.
     * @param price         The price of the product.
     * @param title         The title of the product.
     * @param eTransferEmail The email for eTransfer payment.
     * @param address       The address associated with the product.
     * @param listTags      The list of tags associated with the product.
     *
     * @throws SQLException If there is an error accessing the database.
     * @throws IOException  If there is an error processing the image file.
     */
    public void execute(User user, Image image, String description, String price, String title, String eTransferEmail,
                        String address, ArrayList<String> listTags) throws SQLException, IOException {

        CreateProductInputData createProductInputData = new CreateProductInputData(user, image, description, price, title,
                eTransferEmail, address, listTags);
        createProductInteractor.execute(createProductInputData);
    }
}
