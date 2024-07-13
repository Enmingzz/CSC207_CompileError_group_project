package use_case.search_product;

import java.io.IOException;
import java.sql.SQLException;

public interface SearchProductByTagInputBoundary {
    void execute(SearchProductByTagInputData inputData) throws SQLException, IOException;
}
