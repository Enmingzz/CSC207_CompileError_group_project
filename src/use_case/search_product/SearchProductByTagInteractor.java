package use_case.search_product;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import entity.product.Product;
import entity.user.User;

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
    public void execute(SearchProductByTagInputData inputData) throws SQLException, IOException {
        User user = inputData.getUser();
        ArrayList<Product> products = databaseProductReadByTagDataAccessObject.getProductByTag(inputData.getTag());
        SearchProductByTagOutputData outputData = new SearchProductByTagOutputData(user, products);
        searchProductByTagPresenter.prepareSuccessfulView(outputData);
    }
}
