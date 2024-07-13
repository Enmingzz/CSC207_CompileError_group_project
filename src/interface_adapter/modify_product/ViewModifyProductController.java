package interface_adapter.modify_product;

import entity.product.Product;
import entity.user.User;
import use_case.modify_product.ViewModifyProductInputBoundary;
import use_case.modify_product.ViewModifyProductInputData;

import java.io.IOException;
import java.sql.SQLException;

public class ViewModifyProductController {

    //Upon detecting the click, the controller will
    private final ViewModifyProductInputBoundary viewModifyProductInputBoundary;

    public ViewModifyProductController(ViewModifyProductInputBoundary modifyProductInputBoundary) {
        this.viewModifyProductInputBoundary = modifyProductInputBoundary;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        ViewModifyProductInputData viewModifyProductInputData = new ViewModifyProductInputData(user, product);
        viewModifyProductInputBoundary.execute(viewModifyProductInputData);
    }
}
