package interface_adapter.modify_product;

import use_case.modify_product.CreateProductOutputBoundary;
import use_case.modify_product.CreateProductOutputData;

public class CreateProductPresenter implements CreateProductOutputBoundary {
    private final CreateProductOutputData createProductOutputData;

    public void prepareSuccessfulView(CreateProductOutputData createProductOutputData){
        this.createProductOutputData = createProductOutputData;
    }

}
