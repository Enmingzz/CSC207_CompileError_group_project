package use_case.search_product;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The SearchProductByTagInteractor class implements the SearchProductByTagInputBoundary interface
 * and provides the implementation for searching products by tag.
 */
public class SearchProductByTagInteractor implements SearchProductByTagInputBoundary {
    private final ProductReadByTagDataAccessInterface databaseProductReadByTagDataAccessObject;
    private final SearchProductByTagOutputBoundary searchProductByTagPresenter;

    /**
     * Constructs a SearchProductByTagInteractor with the specified data access interface and presenter.
     *
     * @param databaseProductReadByTagDataAccessObject the data access interface to read products by tag
     * @param searchProductByTagPresenter the presenter to handle the output data
     */
    public SearchProductByTagInteractor(ProductReadByTagDataAccessInterface databaseProductReadByTagDataAccessObject, SearchProductByTagOutputBoundary searchProductByTagPresenter) {
        this.databaseProductReadByTagDataAccessObject = databaseProductReadByTagDataAccessObject;
        this.searchProductByTagPresenter = searchProductByTagPresenter;
    }

    /**
     * Executes the process of searching for products by tag.
     *
     * @param inputData the input data containing the search tag
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void execute(SearchProductByTagInputData inputData) throws SQLException, IOException {
        User user = inputData.getUser();
        ArrayList<Product> products = databaseProductReadByTagDataAccessObject.getProductByTag(inputData.getTag());
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getState() == 0) {
                searchedProducts.add(product);
            }
        }
        SearchProductByTagOutputData outputData = new SearchProductByTagOutputData(user, searchedProducts);
        searchProductByTagPresenter.prepareSuccessfulView(outputData);
    }
}
