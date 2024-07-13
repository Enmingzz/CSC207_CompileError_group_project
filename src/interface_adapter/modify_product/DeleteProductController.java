package interface_adapter.modify_product;

import entity.product.Product;
import entity.user.User;
import use_case.modify_product.DeleteProductInputBoundary;
import use_case.modify_product.DeleteProductInputData;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteProductController {
    private final DeleteProductInputBoundary deleteProductInteractor;

    public DeleteProductController(DeleteProductInputBoundary deleteProductInteractor) {
        this.deleteProductInteractor = deleteProductInteractor;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        DeleteProductInputData deleteProductInputData = new DeleteProductInputData(user, product);
        deleteProductInteractor.execute(deleteProductInputData);
    }
}
