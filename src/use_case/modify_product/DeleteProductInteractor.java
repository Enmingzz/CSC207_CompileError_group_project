package use_case.modify_product;

import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class DeleteProductInteractor implements DeleteProductInputBoundary{
    private final DeleteProductOutputBoundary deleteProductOutputBoundary;
    private final ProductDeleteDataAccessByIDInterface productReadAllDataAccessInterface;

    public DeleteProductInteractor(DeleteProductOutputBoundary deleteProductOutputBoundary, ProductDeleteDataAccessByIDInterface productReadAllDataAccessInterface) {
        this.deleteProductOutputBoundary = deleteProductOutputBoundary;
        this.productReadAllDataAccessInterface = productReadAllDataAccessInterface;
    }

    public void execute(DeleteProductInputData deleteProductInputData) throws SQLException, IOException {
        //Uses the interface to delete the product from the datacase
        productReadAllDataAccessInterface.deleteProductByID(deleteProductInputData.getProduct().getProductID());

        DeleteProductOutputData deleteProductOutputData = new DeleteProductOutputData(deleteProductInputData.getUser(), deleteProductInputData.getProduct());
        deleteProductOutputBoundary.prepareSuccessfulView(deleteProductOutputData);
    }
}
