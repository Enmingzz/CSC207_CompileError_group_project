package interface_adapter.profile;

import entity.product.Product;
import use_case.profile.ManageProductOutputBoundary;
import use_case.profile.ManageProductOutputData;

import java.util.ArrayList;

public class ManageProductPresenter implements ManageProductOutputBoundary {
    @Override
    public void prepareSuccessfulView(ArrayList<Product> products) {

    }
}
