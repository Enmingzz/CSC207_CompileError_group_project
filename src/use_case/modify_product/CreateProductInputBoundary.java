package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

public interface CreateProductInputBoundary {
    void execute(CreateProductInputData createProductInputData) throws SQLException, IOException;

}