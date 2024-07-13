package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

public interface DeleteProductInputBoundary {
    void execute(DeleteProductInputData deleteProductInputData) throws SQLException, IOException;
}
