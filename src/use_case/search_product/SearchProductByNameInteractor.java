package use_case.search_product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchProductByNameInteractor implements SearchProductByNameInputBoundary{

    final private ProductReadByNameDataAccessInterface productReadByNameDataAccessObject;
    final private SearchProductByNameOutputBoundary searchProductByNamePresenter;

    public SearchProductByNameInteractor(ProductReadByNameDataAccessInterface productReadByNameDataAccessObject, SearchProductByNameOutputBoundary searchProductByNamePresenter) {
        this.productReadByNameDataAccessObject = productReadByNameDataAccessObject;
        this.searchProductByNamePresenter = searchProductByNamePresenter;
    }

    @Override
    public void execute(SearchProductByNameInputData inputData) throws SQLException, IOException {
        User user = inputData.getUser();
        ArrayList<Product> products = productReadByNameDataAccessObject.getProductByName(inputData.getProductName());
        SearchProductByNameOutputData outputData = new SearchProductByNameOutputData(user, products);
        searchProductByNamePresenter.prepareSuccessfulView(outputData);
    }
}
