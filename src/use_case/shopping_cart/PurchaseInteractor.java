package use_case.shopping_cart;

import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import entity.user.User;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interactor implementation for purchasing a product.
 * Implements {@link PurchaseInputBoundary}.
 */

public class PurchaseInteractor implements PurchaseInputBoundary {
    final ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject;
    final ProductReadByIdDataAccessInterface productReadByIdDataAccessObject;
    final PurchaseOutputBoundary purchasePresenter;

    /**
     * Constructs a {@code PurchaseInteractor} with the specified dependencies.
     *
     * @param productUpdateStateDataAccessObject   the data access object for updating product state
     * @param productReadByIdDataAccessObject      the data access object for reading product by ID
     * @param purchasePresenter                   the presenter for handling output of purchase
     */

    public PurchaseInteractor(ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject,
                              ProductReadByIdDataAccessInterface productReadByIdDataAccessObject,
                              PurchaseOutputBoundary purchasePresenter) {
        this.productUpdateStateDataAccessObject = productUpdateStateDataAccessObject;
        this.productReadByIdDataAccessObject = productReadByIdDataAccessObject;
        this.purchasePresenter = purchasePresenter;

    }

    /**
     * Purchases a product based on the input data.
     *
     * @param purchaseInputData the input data containing user and product information to purchase
     * @throws SQLException if there's an error accessing the database
     * @throws IOException  if there's an error handling input/output
     */

    @Override
    public void purchaseProduct(PurchaseInputData purchaseInputData) throws SQLException, IOException {
        User user = purchaseInputData.getUser();
        Product product = purchaseInputData.getProduct();

        productUpdateStateDataAccessObject.updateProductState(product, product.getState() + 1);
        Product updated_product = productReadByIdDataAccessObject.getProductById(product.getProductID());

        PurchaseOutputData purchaseOutputData = new PurchaseOutputData(user, updated_product);

        purchasePresenter.prepareSuccessView(purchaseOutputData);
    }
}
