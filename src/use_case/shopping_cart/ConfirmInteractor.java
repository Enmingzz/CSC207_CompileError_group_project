package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

import entity.product.Product;
import entity.user.User;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;

/**
 * Interactor implementation for confirming a product has been received by a buyer.
 * Implements {@link ConfirmInputBoundary}.
 */


public class ConfirmInteractor implements ConfirmInputBoundary {

    final ProductReadByIdDataAccessInterface productReadByIdDataAccessObject;
    final ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject;
    final ConfirmOutputBoundary confirmPresenter;

    /**
     * Constructs a {@code ConfirmInteractor} with the specified dependencies.
     *
     * @param confirmPresenter                 the presenter for handling output of confirmation
     * @param productUpdateStateDataAccessObject the data access object for updating product state
     * @param productReadByIdDataAccessObject   the data access object for reading product by ID
     */

    public ConfirmInteractor(ConfirmOutputBoundary confirmPresenter,
                             ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject,
                             ProductReadByIdDataAccessInterface productReadByIdDataAccessObject) {
        this.confirmPresenter = confirmPresenter;
        this.productReadByIdDataAccessObject = productReadByIdDataAccessObject;
        this.productUpdateStateDataAccessObject = productUpdateStateDataAccessObject;
    }

    /**
     * Confirms a product has been recieved based on the input data.
     *
     * @param confirmInputData the input data containing user and product information to confirm
     * @throws IOException  if there's an error handling input/output
     * @throws SQLException if there's an error accessing the database
     */

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
