package use_case.product_search;

import java.io.IOException;
import java.sql.SQLException;

public interface GetSearchViewInputBoundary {
    void getSearchView(GetSearchViewInputData getSearchViewInputData) throws SQLException, IOException;
}
