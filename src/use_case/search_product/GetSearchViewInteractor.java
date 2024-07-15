package use_case.search_product;

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
