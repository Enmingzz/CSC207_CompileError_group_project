package use_case.search_product;

import java.io.IOException;
import java.sql.SQLException;

public interface GetSearchViewInputBoundary {
    void getSearchView(GetSearchViewInputData getSearchViewInputData) throws SQLException, IOException;
}
