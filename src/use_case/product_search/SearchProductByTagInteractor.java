package use_case.product_search;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchProductByTagInteractor implements SearchProductByTagInputBoundary {
    private final ProductReadByTagDataAccessInterface databaseProductReadByTagDataAccessObject;
    private final SearchProductByTagOutputBoundary searchProductByTagPresenter;

    public SearchProductByTagInteractor(ProductReadByTagDataAccessInterface databaseProductReadByTagDataAccessObject, SearchProductByTagOutputBoundary searchProductByTagPresenter) {
        this.databaseProductReadByTagDataAccessObject = databaseProductReadByTagDataAccessObject;
        this.searchProductByTagPresenter = searchProductByTagPresenter;
    }

    @Override
    public void execute(SearchProductByTagInputData inputData) {
        try {
            ArrayList<Product> products = databaseProductReadByTagDataAccessObject.getProductByTag(inputData.getTag());
            SearchProductByTagOutputData outputData = new SearchProductByTagOutputData(products);
            searchProductByTagPresenter.prepareSuccessfulView(outputData);
        } catch (SQLException | IOException e) {
            e.printStackTrace();

        }
    }
}
