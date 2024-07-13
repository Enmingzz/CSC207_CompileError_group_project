package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

public interface ViewModifyProductInputBoundary {
    //Information about the User and the Product they are wishing to modify are needed
    void execute(ViewModifyProductInputData viewModifyProductInputData) throws SQLException, IOException;
}
