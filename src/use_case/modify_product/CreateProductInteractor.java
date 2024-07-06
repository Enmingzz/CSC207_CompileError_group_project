package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

import entity.product.Product;

import entity.product.ProductFactory;

public class CreateProductInteractor implements CreateProductInputBoundary{

    private final ProductCreateDataAccessInterface productCreateDataAccessObject;
    private final CreateProductOutputBoundary createProductPresenter;
    private final ProductFactory productFactory;

    public CreateProductInteractor(ProductCreateDataAccessInterface productCreateDataAccessObject, CreateProductOutputBoundary createProductPresenter, ProductFactory productFactory) {
        this.productCreateDataAccessObject = productCreateDataAccessObject;
        this.createProductPresenter = createProductPresenter;
        this.productFactory = productFactory;
    }

    public void execute(CreateProductInputData createProductInputData){
        //TODO implement this and ensure the conditions are satisfied before creating the new product

        //the creation of the new product
        Product product = productFactory.createProduct(createProductInputData.getProduct().getImage(), createProductInputData.getProduct().getDescription(), createProductInputData.getProduct().getPrice(),
                createProductInputData.getProduct().getTitle(), createProductInputData.getProduct().getState(), createProductInputData.getProduct().getRating(), createProductInputData.getProduct().geteTransferEmail(),
                createProductInputData.getProduct().getSellerStudentNumber(), createProductInputData.getProduct().getAddress(), createProductInputData.getProduct().getSchedule(),
                createProductInputData.getProduct().getListTags(), createProductInputData.getProduct().getProductID());

        productCreateDataAccessObject.saveProduct(product);

        CreateProductOutputData createProductOutputData = new CreateProductOutputData(); //need to fill in parameters
        createProductPresenter.prepareSuccessfulView(createProductOutputData);
    }
}
