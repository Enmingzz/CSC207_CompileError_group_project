package use_case.search_product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchProductByNameInteractor implements SearchProductByNameInputBoundary{

//    final private ProductReadAllDataAccessInterface productReadAllDataAccessInterface;
    final private SearchProductByNameOutputBoundary searchProductByNamePresenter;
    private ProductReadByNameDataAccessInterface productReadByNameDataAccessInterface;

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


        SearchProductByNameOutputData outputData = new SearchProductByNameOutputData(user, products);
        searchProductByNamePresenter.prepareSuccessfulView(outputData);
    }
}
