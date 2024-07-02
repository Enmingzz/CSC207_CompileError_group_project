package use_case.profile.manage_product;

import java.io.IOException;
import java.sql.SQLException;

public interface ManageProductInputBoundary {

    public void execute(ManageProductInputData manageProductInputData) throws SQLException, IOException;
}
