package use_case.search_product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchProductByNameInteractor implements SearchProductByNameInputBoundary{

    final private ProductReadByNameDataAccessInterface databaseProductReadByNameDataAccessObject;
    final private SearchProductByNameOutputBoundary searchProductByNamePresenter;

    public SearchProductByNameInteractor(ProductReadByNameDataAccessInterface databaseProductReadByNameDataAccessObject, SearchProductByNameOutputBoundary searchProductByNamePresenter) {
        this.databaseProductReadByNameDataAccessObject = databaseProductReadByNameDataAccessObject;
        this.searchProductByNamePresenter = searchProductByNamePresenter;
    }

    @Override
    public void execute(SearchProductByNameInputData inputData) {
        try {
            ArrayList<Product> products = databaseProductReadByNameDataAccessObject.getProductByName(inputData.getProductName());
            SearchProductByNameOutputData outputData = new SearchProductByNameOutputData(products);
            searchProductByNamePresenter.prepareSuccessfulView(outputData);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
