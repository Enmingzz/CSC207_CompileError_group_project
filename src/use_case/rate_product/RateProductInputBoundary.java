package use_case.rate_product;

import java.sql.SQLException;

public interface RateProductInputBoundary {
    public void execute(RateProductInputData rateProductInputData) throws SQLException;
}
