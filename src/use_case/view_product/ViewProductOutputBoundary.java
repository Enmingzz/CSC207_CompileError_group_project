package use_case.view_product;

import java.sql.SQLException;

public interface ViewProductOutputBoundary {
    public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) throws SQLException;
}
