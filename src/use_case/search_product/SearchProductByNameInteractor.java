package use_case.search_product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The SearchProductByNameInteractor class implements the SearchProductByNameInputBoundary interface
 * and provides the implementation for searching products by name.
 */
public class SearchProductByNameInteractor implements SearchProductByNameInputBoundary{

//    final private ProductReadAllDataAccessInterface productReadAllDataAccessInterface;
    final private SearchProductByNameOutputBoundary searchProductByNamePresenter;
    private ProductReadByNameDataAccessInterface productReadByNameDataAccessInterface;

    /**
     * Constructs a SearchProductByNameInteractor with the specified data access interface and presenter.
     *
     * @param productReadByNameDataAccessInterface the data access interface to read products by name
     * @param searchProductByNamePresenter the output boundary to handle the output data
     */
    public SearchProductByNameInteractor( ProductReadByNameDataAccessInterface productReadByNameDataAccessInterface, SearchProductByNameOutputBoundary searchProductByNamePresenter) {
//        this.productReadAllDataAccessInterface = productReadAllDataAccessInterface;
        this.searchProductByNamePresenter = searchProductByNamePresenter;
        this.productReadByNameDataAccessInterface = productReadByNameDataAccessInterface;
    }

    @Override
    public void execute(SearchProductByNameInputData inputData) throws SQLException, IOException {
        User user = inputData.getUser();
        ArrayList<Product> products = productReadByNameDataAccessInterface.getProductByName(inputData.getProductName());

//        String searchTerm = inputData.getProductName().toLowerCase();
//        ArrayList<Product> allProducts = productReadAllDataAccessInterface.getAllProducts();
//
//        // Filter products based on whether their titles/names contain the search term
//        ArrayList<Product> matchingProducts = new ArrayList<>();
//        for (Product product : allProducts) {
//            if (product.getTitle().toLowerCase().contains(searchTerm)) {
//                matchingProducts.add(product);
//            }
//        }
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getState() == 0) {
                searchedProducts.add(product);
            }
        }

        SearchProductByNameOutputData outputData = new SearchProductByNameOutputData(user, searchedProducts);
        searchProductByNamePresenter.prepareSuccessfulView(outputData);
    }
}
