package use_case.main_page;

import entity.product.Product;
import entity.user.User;
import data_access.interfaces.Prouct.ProductReadAllDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowMainPageInteractor implements ShowMainPageInputBoundary{
    final ShowMainPageOutputBoundary mainPagePresenter;
    final ProductReadAllDataAccessInterface productReadAllDataAccessObject;

    public ShowMainPageInteractor(ShowMainPageOutputBoundary mainPagePresenter,
                                  ProductReadAllDataAccessInterface productReadAllDataAccessObject) {
        this.mainPagePresenter = mainPagePresenter;
        this.productReadAllDataAccessObject = productReadAllDataAccessObject;
    }

    @Override
    public void showMainPage(ShowMainPageInputData showMainPageInputData) throws SQLException, IOException {
        User user = showMainPageInputData.getUser();

        ArrayList<Product> allProducts = productReadAllDataAccessObject.getAllProducts();

        ShowMainPageOutputData showMainPageOutputData = new ShowMainPageOutputData(user, allProducts);
        mainPagePresenter.prepareSuccessView(showMainPageOutputData);

    }
}
