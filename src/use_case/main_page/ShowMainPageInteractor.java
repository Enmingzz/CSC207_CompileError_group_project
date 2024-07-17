package use_case.main_page;

import entity.product.Product;
import entity.user.User;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interactor implementation for showing the main page with filtered products.
 * Implements {@link ShowMainPageInputBoundary}.
 */

public class ShowMainPageInteractor implements ShowMainPageInputBoundary{
    final ShowMainPageOutputBoundary mainPagePresenter;
    final ProductReadAllDataAccessInterface productReadAllDataAccessObject;

    /**
     * Constructs a {@code ShowMainPageInteractor} with the specified dependencies.
     *
     * @param mainPagePresenter           the presenter for handling output of the main page
     * @param productReadAllDataAccessObject the data access object for reading all products
     */

    public ShowMainPageInteractor(ShowMainPageOutputBoundary mainPagePresenter,
                                  ProductReadAllDataAccessInterface productReadAllDataAccessObject) {
        this.mainPagePresenter = mainPagePresenter;
        this.productReadAllDataAccessObject = productReadAllDataAccessObject;
    }

    /**
     * Executes the operation to show the main page with filtered products.
     *
     * @param showMainPageInputData the input data containing user information
     * @throws SQLException if there's an error accessing the database
     * @throws IOException  if there's an error handling input/output
     */

    @Override
    public void showMainPage(ShowMainPageInputData showMainPageInputData) throws SQLException, IOException {
        User user = showMainPageInputData.getUser();

        ArrayList<Product> allProducts = productReadAllDataAccessObject.getAllProducts();

        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getState() == 0) {
                filteredProducts.add(product);
            }
        }

        ShowMainPageOutputData showMainPageOutputData = new ShowMainPageOutputData(user, filteredProducts);
        mainPagePresenter.prepareSuccessView(showMainPageOutputData);

    }
}
