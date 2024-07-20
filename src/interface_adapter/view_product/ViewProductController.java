package interface_adapter.view_product;

import entity.user.User;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInputData;
import entity.product.Product;

import java.sql.SQLException;

public class ViewProductController {
    final ViewProductInputBoundary viewProductInteractor;

    public ViewProductController(ViewProductInputBoundary viewProductInteractor){
        this.viewProductInteractor = viewProductInteractor;
    }

    public void execute(Product product, User user) throws SQLException {
        System.out.println("View product controller is called");
        ViewProductInputData viewProductInputData = new ViewProductInputData(product, user);
        viewProductInteractor.execute(viewProductInputData);
    }
}
