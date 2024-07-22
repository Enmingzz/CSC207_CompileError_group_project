package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Interactor class responsible for handling the creation of a new product. It validates the input data
 * and interacts with the data access layer to save the new product.
 */
public class CreateProductInteractor implements CreateProductInputBoundary {

    private final ProductCreateDataAccessInterface productCreateDataAccessObject;
    private final CreateProductOutputBoundary createProductPresenter;
    private final ProductFactory productFactory;

    /**
     * Constructs a CreateProductInteractor instance with the specified data access object, presenter, and product factory.
     *
     * @param productCreateDataAccessObject the data access object for creating the product
     * @param createProductPresenter the presenter for handling output data
     * @param productFactory the factory for creating product instances
     */
    public CreateProductInteractor(ProductCreateDataAccessInterface productCreateDataAccessObject,
                                   CreateProductOutputBoundary createProductPresenter,
                                   ProductFactory productFactory) {
        this.productCreateDataAccessObject = productCreateDataAccessObject;
        this.createProductPresenter = createProductPresenter;
        this.productFactory = productFactory;
    }

    /**
     * Executes the process of creating a new product. It validates the input data and, if valid,
     * creates a new product and saves it using the data access object. Otherwise, it prepares a failed view.
     *
     * @param createProductInputData the input data for creating the product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(CreateProductInputData createProductInputData) throws SQLException, IOException {
        boolean price;
        float floatPrice = 0;
        try {
            floatPrice = Float.parseFloat(createProductInputData.getPrice());
            if (floatPrice >= 0) {
                price = true;
            } else {
                price = false;
            }
        } catch (NumberFormatException e) {
            price = false;
        }
        boolean image = !(createProductInputData.getImage() == null);
        boolean description = !(Objects.equals(createProductInputData.getDescription(), ""));
        boolean title = !(Objects.equals(createProductInputData.getTitle(), ""));
        boolean eTransferEmail = !(Objects.equals(createProductInputData.geteTransferEmail(), ""));
        boolean address = !(Objects.equals(createProductInputData.getAddress(), ""));
        boolean tags = !(createProductInputData.getListTags().isEmpty());

        if (!image) {
            createProductPresenter.prepareFailedView("You must upload a valid image of the product.");
        } else if (!description) {
            createProductPresenter.prepareFailedView("You must enter a valid description for the product.");
        } else if (!price) {
            createProductPresenter.prepareFailedView("You must indicate a valid price of the product.");
        } else if (!title) {
            createProductPresenter.prepareFailedView("You must provide a valid title for the product.");
        } else if (!eTransferEmail) {
            createProductPresenter.prepareFailedView("You must provide a valid eTransfer email for the product.");
        } else if (!address) {
            createProductPresenter.prepareFailedView("You must provide a valid address for the pickup location.");
        } else if (!tags) {
            createProductPresenter.prepareFailedView("You must select at least one tag for the product.");
        } else {
            LocalTime currentTime = LocalTime.now();
            String productID = currentTime.toString();

            Schedule schedule = new CommonSchedule(null, new ArrayList<>());
            Product product = productFactory.createProduct(createProductInputData.getImage(), createProductInputData.getDescription(),
                    createProductInputData.getTitle(), Float.parseFloat(createProductInputData.getPrice()), null, 0,
                    createProductInputData.geteTransferEmail(), createProductInputData.getUser().getStudentNumber(),
                    createProductInputData.getAddress(), createProductInputData.getListTags(), productID, schedule);

            productCreateDataAccessObject.saveProduct(product);

            CreateProductOutputData createProductOutputData = new CreateProductOutputData(createProductInputData.getUser(), product);
            createProductPresenter.prepareSuccessfulView(createProductOutputData);
        }
    }
}
