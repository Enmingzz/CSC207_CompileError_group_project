package use_case.profile.manage_product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interactor class for managing products.
 * Implements the ManageProductInputBoundary interface to handle the action of managing products.
 */
public class ManageProductInteractor implements ManageProductInputBoundary {

    private final ManageProductOutputBoundary manageProductPresenter;
    private final ProductReadByUserDataAccessInterface productReadByUserDataAccess;

    /**
     * Constructs a ManageProductInteractor with the given presenter and data access interface.
     *
     * @param manageProductPresenter the presenter for managing products
     * @param productReadByUserDataAccess the data access interface for reading products by user
     */
    public ManageProductInteractor(ManageProductOutputBoundary manageProductPresenter, ProductReadByUserDataAccessInterface productReadByUserDataAccess) {
        this.manageProductPresenter = manageProductPresenter;
        this.productReadByUserDataAccess = productReadByUserDataAccess;
    }

    /**
     * Executes the action of managing products.
     * Retrieves products associated with the user and passes them to the presenter.
     *
     * @param manageProductInputData the input data for managing products
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void execute(ManageProductInputData manageProductInputData) throws SQLException, IOException {
        ArrayList<Product> products = productReadByUserDataAccess.getProductByUser(
                manageProductInputData.getUser().getStudentNumber());
        ManageProductOutputData manageProductOutputData = new ManageProductOutputData(products, manageProductInputData.getUser());
        manageProductPresenter.prepareSuccessfulView(manageProductOutputData);
    }
}
