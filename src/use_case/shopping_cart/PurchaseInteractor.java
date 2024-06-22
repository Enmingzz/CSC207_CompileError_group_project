package use_case.shopping_cart;

import data_access.interfaces.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.ProductReadByIdDataAccessInterface;
import entity.user.User;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;


public class PurchaseInteractor implements PurchaseInputBoundary {
    final ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject;
    final ProductReadByIdDataAccessInterface productReadByIdDataAccessObject;
    final PurchaseOutputBoundary purchasePresenter;

    public PurchaseInteractor(ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject,
                              ProductReadByIdDataAccessInterface productReadByIdDataAccessObject,
                              PurchaseOutputBoundary purchasePresenter) {
        this.productUpdateStateDataAccessObject = productUpdateStateDataAccessObject;
        this.productReadByIdDataAccessObject = productReadByIdDataAccessObject;
        this.purchasePresenter = purchasePresenter;

    }

    @Override
    public void purchaseProduct(PurchaseInputData purchaseInputData) throws SQLException, IOException {
        User user = purchaseInputData.getUser();
        Product product = purchaseInputData.getProduct();

        productUpdateStateDataAccessObject.updateProductState(product, product.getState() + 1);
        Product updated_product = productReadByIdDataAccessObject.getProductById(product.getProductID());

        PurchaseOutputData purchaseOutputData = new PurchaseOutputData(user, updated_product);
}
