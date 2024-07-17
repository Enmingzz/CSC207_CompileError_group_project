package use_case.search_product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.Product;
import entity.user.User;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The GetSearchViewInteractor class implements the GetSearchViewInputBoundary interface
 * and provides the implementation for retrieving the search page.
 */
public class GetSearchViewInteractor implements GetSearchViewInputBoundary {
    final GetSearchViewOutputBoundary getSearchViewOutputBoundary;
    final ProductReadAllDataAccessInterface productReadAllDataAccessObject;

    /**
     * Constructs a GetSearchViewInteractor with the specified output boundary and data access object.
     *
     * @param getSearchViewOutputBoundary the output boundary to handle the output data
     * @param productReadAllDataAccessObject the data access object to read all products
     */
    public GetSearchViewInteractor(GetSearchViewOutputBoundary getSearchViewOutputBoundary,
                                  ProductReadAllDataAccessInterface productReadAllDataAccessObject) {
        this.getSearchViewOutputBoundary = getSearchViewOutputBoundary;
        this.productReadAllDataAccessObject = productReadAllDataAccessObject;
    }

    /**
     * Executes the process of getting all products that are on sale and retrieving the search page.
     *
     * @param getSearchViewInputData the input data containing necessary information to retrieve the search page
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void getSearchView(GetSearchViewInputData getSearchViewInputData) throws SQLException, IOException {
        User user = getSearchViewInputData.getUser();

        // get all products that are on sale
        ArrayList<Product> allProducts = productReadAllDataAccessObject.getAllProducts();
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getState() == 0) {
                searchedProducts.add(product);
            }
        }

        GetSearchViewOutputData getSearchViewOutputData = new GetSearchViewOutputData(user, searchedProducts);
        getSearchViewOutputBoundary.prepareSuccessView(getSearchViewOutputData);

    }


}
