package use_case.rate_product;

import use_case.modify_product.ChangeProductOutputData;

import java.io.IOException;
import java.sql.SQLException;

public interface RateProductOutputBoundary {
    public void prepareSuccessfulView(RateProductOutputData rateProductOutputData) throws SQLException, IOException;
    public void prepareFailedView(String error) throws SQLException, IOException;
}
