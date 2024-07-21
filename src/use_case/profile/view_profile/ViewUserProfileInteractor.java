package use_case.profile.view_profile;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class ViewUserProfileInteractor implements ViewUserProfileInputBoundary{

    private final ViewUserProfileOutputBoundary viewUserProfilePresenter;

    public ViewUserProfileInteractor(ViewUserProfileOutputBoundary viewUserProfilePresenter) {
        this.viewUserProfilePresenter = viewUserProfilePresenter;
    }

    @Override
    public void execute(ViewUserProfileInputData userProfileInputData) {
        ArrayList<Product> products = getProducts(userProfileInputData.getSeller());
        ViewUserProfileOutputData viewUserProfileOutput =
                new ViewUserProfileOutputData(userProfileInputData.getSeller(),
                        userProfileInputData.getBuyer(), products);
        viewUserProfilePresenter.prepareSuccessfulView(viewUserProfileOutput);
    }

    public static ArrayList<Product> getProducts(User user) {
        ArrayList<Product> products = new ArrayList<>();

        return products;
    }
}
