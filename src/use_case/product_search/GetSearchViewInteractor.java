package use_case.product_search;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.Product;
import entity.user.User;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetSearchViewInteractor implements GetSearchViewInputBoundary {
    final GetSearchViewOutputBoundary getSearchViewOutputBoundary;
    final ProductReadAllDataAccessInterface productReadAllDataAccessObject;

    public GetSearchViewInteractor(GetSearchViewOutputBoundary getSearchViewOutputBoundary,
                                  ProductReadAllDataAccessInterface productReadAllDataAccessObject) {
        this.getSearchViewOutputBoundary = getSearchViewOutputBoundary;
        this.productReadAllDataAccessObject = productReadAllDataAccessObject;
    }

    @Override
    public void getSearchView(GetSearchViewInputData getSearchViewInputData) throws SQLException, IOException {
        User user = getSearchViewInputData.getUser();

        ArrayList<Product> allProducts = productReadAllDataAccessObject.getAllProducts();

        GetSearchViewOutputData getSearchViewOutputData = new GetSearchViewOutputData(user, allProducts);
        getSearchViewOutputBoundary.prepareSuccessView(getSearchViewOutputData);

    }


}
