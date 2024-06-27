package use_case.main_page;

import java.io.IOException;
import java.sql.SQLException;

public interface ShowMainPageInputBoundary {
    void showMainPage(ShowMainPageInputData showMainPageInputData) throws SQLException, IOException;
}
