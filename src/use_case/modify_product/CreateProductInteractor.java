package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

import entity.product.Product;

import entity.product.ProductFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

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
        if (createProductInputData.getImage() == null) {
            createProductPresenter.prepareFailedView("You must upload an image of the product.");
        }
        if (createProductInputData.getPrice() == "") {
            createProductPresenter.prepareFailedView("You must indicate the price of the product.");
        }
        try {
            float floatValue = Float.parseFloat(createProductInputData.getPrice());
        }
        catch (NumberFormatException e){
            createProductPresenter.prepareFailedView("You must enter a the price of the product.");
        }
        //TODO finish this part off and the rest

        LocalTime currentTime = LocalTime.now();
        String productID = currentTime.toString();


        //the creation of the new product
        Product product = productFactory.createProduct(createProductInputData.getImage(), createProductInputData.getDescription(),
                createProductInputData.getTitle(), Float.parseFloat(createProductInputData.getPrice()), null, 0,
                createProductInputData.geteTransferEmail(), createProductInputData.getUser().getStudentNumber(),
                createProductInputData.getAddress(), createProductInputData.getListTags(), productID, null);

        productCreateDataAccessObject.saveProduct(product);

        CreateProductOutputData createProductOutputData = new CreateProductOutputData(createProductInputData.getUser(), product); //need to fill in parameters
        createProductPresenter.prepareSuccessfulView(createProductOutputData);

    }
}