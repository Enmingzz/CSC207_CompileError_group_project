package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

public interface ChangeProductInputBoundary {
    void execute(ChangeProductInputData changeProductInputData) throws SQLException, IOException;
}
