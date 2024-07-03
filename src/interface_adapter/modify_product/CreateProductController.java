package interface_adapter.modify_product;

import use_case.modify_product.CreateProductInputBoundary;
import use_case.modify_product.CreateProductInputData;

public class CreateProductController {

    private final CreateProductInputBoundary createProductInteractor;

    public CreateProductController(CreateProductInputBoundary createProductInteractor) {
        this.createProductInteractor = createProductInteractor;
    }

    public void execute(){
        //TODO
        CreateProductInputData createProductInputData = new CreateProductInputData();
        createProductInteractor.execute(createProductInputData);
    }
}
