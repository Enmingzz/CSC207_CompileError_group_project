package use_case.search_product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
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

    final private ProductReadAllDataAccessInterface productReadAllDataAccessInterface;
    final private SearchProductByNameOutputBoundary searchProductByNamePresenter;
    private final ProductReadByNameDataAccessInterface productReadByNameDataAccessInterface;

    /**
     * Constructs a SearchProductByNameInteractor with the specified data access interface and presenter.
     *
     * @param productReadByNameDataAccessInterface the data access interface to read products by name
     * @param productReadAllDataAccessInterface the data access interface to read all products
     * @param searchProductByNamePresenter the output boundary to handle the output data
     */
    public SearchProductByNameInteractor(ProductReadAllDataAccessInterface productReadAllDataAccessInterface, ProductReadByNameDataAccessInterface productReadByNameDataAccessInterface, SearchProductByNameOutputBoundary searchProductByNamePresenter) {
        this.productReadAllDataAccessInterface = productReadAllDataAccessInterface;
        this.searchProductByNamePresenter = searchProductByNamePresenter;
        this.productReadByNameDataAccessInterface = productReadByNameDataAccessInterface;
    }

    @Override
    public void execute(SearchProductByNameInputData inputData) throws SQLException, IOException {

        User user = inputData.getUser();
        String searchTerm = inputData.getProductName(); // Search by name is case-sensitive search

        // Get exact match products
        ArrayList<Product> exactMatchProducts = productReadByNameDataAccessInterface.getProductByName(inputData.getProductName());

        // Get all products
        ArrayList<Product> allProducts = productReadAllDataAccessInterface.getAllProducts();

        // Filter products based on whether their titles/names contain the search term
        ArrayList<Product> matchingProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (!exactMatchProducts.contains(product) && product.getTitle().toLowerCase().contains(searchTerm)) {
                matchingProducts.add(product);
            }
        }

        // Combine exact matches and matching products, ensuring exact matches come first
        ArrayList<Product> searchedProducts = new ArrayList<>(exactMatchProducts);
        searchedProducts.addAll(matchingProducts);

        // Filter products that have state 0
        ArrayList<Product> outputProducts = new ArrayList<>();
        for (Product product : searchedProducts) {
            if (product.getState() == 0) {
                outputProducts.add(product);
            }
        }


        SearchProductByNameOutputData outputData = new SearchProductByNameOutputData(user, outputProducts);
        searchProductByNamePresenter.prepareSuccessfulView(outputData);
    }
}
