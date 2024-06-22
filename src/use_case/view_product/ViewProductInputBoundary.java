package use_case.view_product;

import java.sql.SQLException;

public interface ViewProductInputBoundary {
    public void execute(ViewProductInputData viewProductInputData) throws SQLException;
}

