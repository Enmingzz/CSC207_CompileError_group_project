package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

public class CreateProductInteractor implements CreateProductInputBoundary{

    private final ProductCreateDataAccessInterface productCreateDataAccessObject;
    private final CreateProductOutputBoundary createProductPresenter;

    public CreateProductInteractor(ProductCreateDataAccessInterface productCreateDataAccessObject, CreateProductOutputBoundary createProductPresenter) {
        this.productCreateDataAccessObject = productCreateDataAccessObject;
        this.createProductPresenter = createProductPresenter;
    }

    public void execute(CreateProductInputData createProductInputData){
        //TODO need to implement this method
        CreateProductOutputData createProductOutputData = new CreateProductOutputData();
        createProductPresenter.prepareSuccessfulView(createProductOutputData);
    }

}
