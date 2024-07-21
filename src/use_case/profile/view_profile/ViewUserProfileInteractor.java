package use_case.profile.view_profile;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.objects.user.DatabaseUserReadDataAccessObject;
import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interactor class for viewing a user's profile.
 * This class handles the business logic for retrieving user data and associated products.
 */
public class ViewUserProfileInteractor implements ViewUserProfileInputBoundary {

    private final ViewUserProfileOutputBoundary viewUserProfilePresenter;
    private final UserReadDataAccessInterface databaseUserReadDataAccessObject;
    private final ProductReadByUserDataAccessInterface databaseProductReadDataAccessObject;

    /**
     * Constructs a ViewUserProfileInteractor with the specified presenter and data access objects.
     *
     * @param viewUserProfilePresenter the presenter to handle the output
     * @param databaseUserReadDataAccessObject the data access object for reading user data
     * @param databaseProductReadDataAccessObject the data access object for reading product data by user
     */
    public ViewUserProfileInteractor(ViewUserProfileOutputBoundary viewUserProfilePresenter,
                                     UserReadDataAccessInterface databaseUserReadDataAccessObject,
                                     ProductReadByUserDataAccessInterface databaseProductReadDataAccessObject) {
        this.viewUserProfilePresenter = viewUserProfilePresenter;
        this.databaseUserReadDataAccessObject = databaseUserReadDataAccessObject;
        this.databaseProductReadDataAccessObject = databaseProductReadDataAccessObject;
    }

    /**
     * Executes the use case to view a user's profile.
     *
     * @param userProfileInputData the input data containing the seller's student number and the buyer's information
     * @throws SQLException if there is an error accessing the database
     * @throws IOException if there is an I/O error
     */
    @Override
    public void execute(ViewUserProfileInputData userProfileInputData) throws SQLException, IOException {
        User seller = databaseUserReadDataAccessObject.getUser(userProfileInputData.getSellerStudentNumber());
        ArrayList<Product> products = databaseProductReadDataAccessObject.getProductByUser(seller.getStudentNumber());
        ViewUserProfileOutputData viewUserProfileOutput =
                new ViewUserProfileOutputData(seller, userProfileInputData.getBuyer(), products);
        viewUserProfilePresenter.prepareSuccessfulView(viewUserProfileOutput);
    }
}
