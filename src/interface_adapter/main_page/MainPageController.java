package interface_adapter.main_page;

import entity.user.User;
import use_case.main_page.ShowMainPageInputData;
import use_case.main_page.ShowMainPageInputBoundary;

import java.io.IOException;
import java.sql.SQLException;

public class MainPageController {
    final ShowMainPageInputBoundary showMainPageInteractor;

    public MainPageController(ShowMainPageInputBoundary showMainPageInteractor) {
        this.showMainPageInteractor = showMainPageInteractor;
    }

    public void execute(User user) throws SQLException, IOException {
        ShowMainPageInputData showMainPageInputData = new ShowMainPageInputData(user);

        showMainPageInteractor.showMainPage(showMainPageInputData);
    };

}
