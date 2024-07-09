package use_case.search_product;

import java.io.IOException;
import java.sql.SQLException;

public interface SearchProductByNameInputBoundary {

    void execute(SearchProductByNameInputData inputData) throws SQLException, IOException;
}
