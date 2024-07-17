package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;

public class ViewCreateProductInteractor implements ViewCreateProductInputBoundary{
    private final ViewCreateProductOutputBoundary viewcreateProductOutputBoundary;

    public ViewCreateProductInteractor(ViewCreateProductOutputBoundary viewcreateProductOutputBoundary) {
        this.viewcreateProductOutputBoundary = viewcreateProductOutputBoundary;
    }

    public void execute(ViewCreateProductInputData viewCreateProductInputData){
        ViewCreateProductOutputData viewCreateProductOutputData = new ViewCreateProductOutputData(viewCreateProductInputData.getUser());
    }
}
