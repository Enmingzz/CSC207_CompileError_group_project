package use_case.profile.view_profile;

import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.objects.user.DatabaseUserReadDataAccessObject;
import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViewUserProfileInteractor implements ViewUserProfileInputBoundary{

    private final ViewUserProfileOutputBoundary viewUserProfilePresenter;
    private final UserReadDataAccessInterface databaseUserReadDataAccessObject;

    public ViewUserProfileInteractor(ViewUserProfileOutputBoundary viewUserProfilePresenter, UserReadDataAccessInterface databaseUserReadDataAccessObject) {
        this.viewUserProfilePresenter = viewUserProfilePresenter;
        this.databaseUserReadDataAccessObject = databaseUserReadDataAccessObject;
    }

    @Override
    public void execute(ViewUserProfileInputData userProfileInputData) throws SQLException {
        User seller = databaseUserReadDataAccessObject.getUser(userProfileInputData.getSellerStudentNumber())
        ArrayList<Product> products = getProducts(seller);
        ViewUserProfileOutputData viewUserProfileOutput =
                new ViewUserProfileOutputData(seller,
                        userProfileInputData.getBuyer(), products);
        viewUserProfilePresenter.prepareSuccessfulView(viewUserProfileOutput);
    }

    public static ArrayList<Product> getProducts(User user) {
        ArrayList<Product> products = new ArrayList<>();

        return products;
    }
}
