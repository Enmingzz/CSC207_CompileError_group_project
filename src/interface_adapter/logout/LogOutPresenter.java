package interface_adapter.logout;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.main_page.MainPageState;
import interface_adapter.main_page.MainPageViewModel;
import use_case.logout.LogOutOutputBoundary;
import use_case.logout.LogOutOutputData;

/**
 * Presenter class for the logout process.
 * Implements the LogOutOutputBoundary interface to handle the logout output data and update the view models.
 */
public class LogOutPresenter implements LogOutOutputBoundary {
    private final MainPageViewModel mainPageViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a LogOutPresenter with the given main page view model and view manager model.
     *
     * @param mainPageViewModel the main page view model
     * @param viewManagerModel the view manager model
     */
    public LogOutPresenter(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel) {
        this.mainPageViewModel = mainPageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares a successful view for the logout process.
     * Updates the main page state with a new anonymous user and fires a property change event.
     *
     * @param logOutOutputData the output data for the logout process
     */
    @Override
    public void prepareSuccessfulView(LogOutOutputData logOutOutputData) {
        MainPageState state = mainPageViewModel.getState();
        UserFactory commonUserFactory = new CommonUserFactory();
        User user = commonUserFactory.createUser("", "", "", 0, "");
        state.setUser(user);
        mainPageViewModel.firePropertyChanged();
    }
}
