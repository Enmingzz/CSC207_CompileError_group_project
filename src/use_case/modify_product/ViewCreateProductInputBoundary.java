package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

public interface ViewCreateProductInputBoundary {
    void execute(ViewCreateProductInputData viewCreateProductInputData) throws SQLException, IOException;
}
