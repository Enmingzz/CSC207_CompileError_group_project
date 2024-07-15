package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

public interface CreateProductOutputBoundary {

    public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) throws SQLException, IOException;
    public void prepareFailedView(String error);
}
