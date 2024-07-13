package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

import entity.product.Product;
import entity.user.User;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;


public class ConfirmInteractor implements ConfirmInputBoundary {

    final ProductReadByIdDataAccessInterface productReadByIdDataAccessObject;
    final ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject;
    final ConfirmOutputBoundary confirmPresenter;

    public ConfirmInteractor(ConfirmOutputBoundary confirmPresenter,
                             ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject,
                             ProductReadByIdDataAccessInterface productReadByIdDataAccessObject) {
        this.confirmPresenter = confirmPresenter;
        this.productReadByIdDataAccessObject = productReadByIdDataAccessObject;
        this.productUpdateStateDataAccessObject = productUpdateStateDataAccessObject;
    }

    @Override
    public void confirm(ConfirmInputData confirmInputData) throws IOException, SQLException {
        User user = confirmInputData.getUser();
        Product product = confirmInputData.getProduct();

        productUpdateStateDataAccessObject.updateProductState(product, product.getState() + 1);
        Product updated_product = productReadByIdDataAccessObject.getProductById(product.getProductID());
        ConfirmOutputData confirmOutputData = new ConfirmOutputData(user, updated_product);
        confirmPresenter.prepareSuccessView(confirmOutputData);
    }
}
