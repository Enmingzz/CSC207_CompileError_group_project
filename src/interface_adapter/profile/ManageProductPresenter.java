package interface_adapter.profile;

import entity.product.Product;
import use_case.profile.ManageProductInteractor;
import use_case.profile.ManageProductOutputBoundary;
import use_case.profile.ManageProductOutputData;

import java.util.ArrayList;

public class ManageProductPresenter implements ManageProductOutputBoundary {
    @Override
    public void prepareSuccessfulView(ManageProductOutputData response) {
        // TODO need to implement this method
    }
}
