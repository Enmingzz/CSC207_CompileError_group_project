package use_case.modify_product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

public class ViewModifyProductInteractor implements ViewModifyProductInputBoundary {
    private final ViewModifyProductOutputBoundary viewModifyProductOutputBoundary;

    public ViewModifyProductInteractor(ViewModifyProductOutputBoundary viewModifyProductOutputBoundary) {
        this.viewModifyProductOutputBoundary = viewModifyProductOutputBoundary;
    }

    public void execute(ViewModifyProductInputData viewModifyProductInputData) {
        ViewModifyProductOutputData viewModifyProductOutputData = new ViewModifyProductOutputData(viewModifyProductInputData.getUser(), viewModifyProductInputData.getProduct());
        viewModifyProductOutputBoundary.prepareSuccessfulView(viewModifyProductOutputData);
    }
}
