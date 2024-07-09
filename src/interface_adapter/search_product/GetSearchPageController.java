package interface_adapter.search_product;

import entity.user.User;
import use_case.product_search.GetSearchViewInputBoundary;
import use_case.product_search.GetSearchViewInputData;

import java.io.IOException;
import java.sql.SQLException;

public class GetSearchPageController {
    GetSearchViewInputBoundary getSearchViewInputBoundary;

    public GetSearchPageController(GetSearchViewInputBoundary getSearchViewInputBoundary) {
        this.getSearchViewInputBoundary = getSearchViewInputBoundary;
    }

    public void execute(User user) throws SQLException, IOException {
        GetSearchViewInputData getSearchViewInputData = new GetSearchViewInputData(user);
        getSearchViewInputBoundary.getSearchView(getSearchViewInputData);
    }
}
