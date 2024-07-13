package interface_adapter.modify_product;

import entity.user.User;
import use_case.modify_product.CreateProductOutputData;
import use_case.modify_product.ViewCreateProductInputBoundary;
import use_case.modify_product.ViewCreateProductInputData;

import java.io.IOException;
import java.sql.SQLException;

public class ViewCreateProductController {
    private final ViewCreateProductInputBoundary viewCreateProductInteractor;

    public ViewCreateProductController(ViewCreateProductInputBoundary viewCreateProductInteractor) {
        this.viewCreateProductInteractor = viewCreateProductInteractor;
    }

    public void execute(User user) throws SQLException, IOException {
        ViewCreateProductInputData viewCreateProductInputData = new ViewCreateProductInputData(user);
        viewCreateProductInteractor.execute(viewCreateProductInputData);
    }
}
