package interface_adapter.modify_product;

import entity.product.Product;
import entity.user.User;
import use_case.modify_product.ChangeProductInputBoundary;
import use_case.modify_product.ChangeProductInputData;
import use_case.modify_product.ViewModifyProductInputBoundary;
import use_case.modify_product.ViewModifyProductInputData;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class ModifyProductController {
    private final ChangeProductInputBoundary changeProductInputInteractor;

    public ModifyProductController(ChangeProductInputBoundary changeProductInputInteractor) {
        this.changeProductInputInteractor = changeProductInputInteractor;
    }

    public void execute(User user, Product product, String changedDescription, String changedPrice, Image changedImage) throws SQLException, IOException {
        ChangeProductInputData changeProductInputData = new ChangeProductInputData(user, product, changedDescription, changedPrice, changedImage);
        changeProductInputInteractor.execute(changeProductInputData);
    }

}
