package interface_adapter.main_page;

import entity.user.User;
import use_case.main_page.ShowMainPageInputData;
import use_case.main_page.ShowMainPageInputBoundary;

import java.io.IOException;
import java.sql.SQLException;
/**
 * Controller for the main page, responsible for handling user interactions and invoking the use case to display the main page.
 */
public class MainPageController {
    final ShowMainPageInputBoundary showMainPageInteractor;

    /**
     * Constructs a {@link MainPageController} with the specified interactor.
     *
     * @param showMainPageInteractor the interactor to handle the main page logic
     */
    public MainPageController(ShowMainPageInputBoundary showMainPageInteractor) {
        this.showMainPageInteractor = showMainPageInteractor;
    }

    /**
     * Executes the main page use case for the specified user.
     *
     * @param user the user for whom the main page is to be displayed
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public void execute(User user)  throws SQLException, IOException {
        ShowMainPageInputData showMainPageInputData = new ShowMainPageInputData(user);

        showMainPageInteractor.showMainPage(showMainPageInputData);
    };

}
