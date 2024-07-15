package use_case.rate_product;

import java.io.IOException;
import java.sql.SQLException;

public interface RateProductInputBoundary {
    public void execute(RateProductInputData rateProductInputData) throws SQLException, IOException;
}
