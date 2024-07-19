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

public class CreateProductInteractor implements CreateProductInputBoundary{

    private final ProductCreateDataAccessInterface productCreateDataAccessObject;
    private final CreateProductOutputBoundary createProductPresenter;
    private final ProductFactory productFactory;

    public CreateProductInteractor(ProductCreateDataAccessInterface productCreateDataAccessObject, CreateProductOutputBoundary createProductPresenter, ProductFactory productFactory) {
        this.productCreateDataAccessObject = productCreateDataAccessObject;
        this.createProductPresenter = createProductPresenter;
        this.productFactory = productFactory;
    }
    public void execute(CreateProductInputData createProductInputData) throws SQLException, IOException {
        //TODO implement this and ensure the conditions are satisfied before creating the new product
        boolean price;
        float floatPrice = 0;
        try {
            floatPrice = Float.parseFloat(createProductInputData.getPrice());
            if(floatPrice >= 0) {
                price = true;
            }
            else{
                price = false;
            }
        } catch (NumberFormatException e) {
            price = false;

        }
        boolean image = !(createProductInputData.getImage() == null);

        boolean title =  !(Objects.equals(createProductInputData.getTitle(), ""));
        boolean eTransferEmail = !(Objects.equals(createProductInputData.geteTransferEmail(), ""));
        boolean address = !(Objects.equals(createProductInputData.getAddress(), ""));
        boolean tags = !(createProductInputData.getListTags().isEmpty());

        if (!image) {
            createProductPresenter.prepareFailedView("You must upload a valid image of the product.");
        }
        else if(!price) {
            createProductPresenter.prepareFailedView("You must indicate a valid price of the product.");
        }
        else if(!title) {
            createProductPresenter.prepareFailedView("You must provide a valid title for the product.");
        }
        else if(!eTransferEmail) {
            createProductPresenter.prepareFailedView("You must provide a valid eTransfer email for the product.");
        }
        else if(!address) {
            createProductPresenter.prepareFailedView("You must provide a valid address for the pickup location.");
        }
        else if(!tags) {
            createProductPresenter.prepareFailedView("You must select at least one tag for the product.");
        }
        else {
            LocalTime currentTime = LocalTime.now();
            String productID = currentTime.toString();

            Schedule schedule = new CommonSchedule(null, new ArrayList<>());
            //the creation of the new product
            Product product = productFactory.createProduct(createProductInputData.getImage(), createProductInputData.getDescription(),
                    createProductInputData.getTitle(), Float.parseFloat(createProductInputData.getPrice()), null, 0,
                    createProductInputData.geteTransferEmail(), createProductInputData.getUser().getStudentNumber(),
                    createProductInputData.getAddress(), createProductInputData.getListTags(), productID, schedule);

            productCreateDataAccessObject.saveProduct(product);

            CreateProductOutputData createProductOutputData = new CreateProductOutputData(createProductInputData.getUser(), product); //need to fill in parameters
            createProductPresenter.prepareSuccessfulView(createProductOutputData);
        }
    }
}