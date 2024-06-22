package interface_adapter;

import use_case.ViewProductInputBoundary;
import use_case.ViewProductInputData;
import entity.product.Product;

import java.sql.SQLException;

public class ViewProductController {
    final ViewProductInputBoundary viewProductInteractor;

    public ViewProductController(ViewProductInputBoundary viewProductInteractor){
        this.viewProductInteractor = viewProductInteractor;
    }

    public void execute(Product product) throws SQLException {
        ViewProductInputData viewProductInputData = new ViewProductInputData(product);
        viewProductInteractor.execute(viewProductInputData);
    }
}
