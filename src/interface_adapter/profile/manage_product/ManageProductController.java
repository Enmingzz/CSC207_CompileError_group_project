package interface_adapter.profile.manage_product;

import entity.user.User;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInputData;

import java.io.IOException;
import java.sql.SQLException;

public class ManageProductController {

    private final ManageProductInputBoundary manageProductInteractor;

    public ManageProductController(ManageProductInputBoundary manageProductInteractor) {
        this.manageProductInteractor = manageProductInteractor;
    }

    public void execute(User user) throws SQLException, IOException {
        ManageProductInputData manageProductInputData = new ManageProductInputData(user);
        manageProductInteractor.execute(manageProductInputData);
    }

}
