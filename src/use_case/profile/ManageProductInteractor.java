package use_case.profile;

import data_access.interfaces.Prouct.ProductReadByUserDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageProductInteractor implements ManageProductInputBoundary{

    private final ManageProductOutputBoundary manageProductPresenter;
    private final ProductReadByUserDataAccessInterface productReadByUserDataAccess;

    public ManageProductInteractor(ManageProductOutputBoundary manageProductPresenter, ProductReadByUserDataAccessInterface productReadByUserDataAccess) {
        this.manageProductPresenter = manageProductPresenter;
        this.productReadByUserDataAccess = productReadByUserDataAccess;
    }

    public void execute(ManageProductInputData manageProductInputData) throws SQLException, IOException {
        ArrayList<Product> products = productReadByUserDataAccess.getProductByUser(
                manageProductInputData.getUser().getStudentNumber());
        ManageProductOutputData manageProductOutputData = new ManageProductOutputData(products);
        manageProductPresenter.prepareSuccessfulView(manageProductOutputData);
    }

}
