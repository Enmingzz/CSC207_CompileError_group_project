package app.user_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByTagDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByTagDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.*;
import interface_adapter.login.*;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.*;
import use_case.search_product.*;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.*;
import use_case.login.*;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.signup.SignupView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Factory class to create instances related to the signup use case.
 */
public class SignupUseCaseFactory {

    /**
     * Private constructor to prevent instantiation.
     */
    private SignupUseCaseFactory() {
    }

    /**
     * Creates an instance of {@link SignupView} with the necessary controllers and view models.
     *
     * @param viewManagerModel       the view manager model
     * @param loginViewModel         the login view model
     * @param signupViewModel        the signup view model
     * @param mainPageViewModel      the main page view model
     * @param shoppingCartViewModel  the shopping cart view model
     * @param searchProductViewModel the search product view model
     * @param LoginViewModel         the login view model
     * @param viewProfileViewModel   the view profile view model
     * @return an instance of {@link SignupView}
     */
    public static SignupView create(ViewManagerModel viewManagerModel,
                                    LoginViewModel loginViewModel,
                                    SignupViewModel signupViewModel,
                                    MainPageViewModel mainPageViewModel,
                                    ShoppingCartViewModel shoppingCartViewModel,
                                    SearchProductViewModel searchProductViewModel,
                                    LoginViewModel LoginViewModel,
                                    ViewProfileViewModel viewProfileViewModel) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
            EmailVerificationController emailVerificationController = SignupUseCaseFactory.createEmailVerifyUseCase(viewManagerModel, signupViewModel);
            MainPageController mainPageController =
                    SignupUseCaseFactory.createMainPageController(mainPageViewModel,
                    viewManagerModel);
            ShoppingCartController shoppingCartController =
                    SignupUseCaseFactory.createShoppingCartController(viewManagerModel,
                            shoppingCartViewModel);
            SearchProductByNameController searchProductByNameController =
                    SignupUseCaseFactory.createSearchProductByNameController(viewManagerModel,
                            searchProductViewModel);
            SearchProductByTagController searchProductByTagController =
                    SignupUseCaseFactory.createSearchProductByTagController(viewManagerModel, searchProductViewModel);
            ViewLoginPageController viewLoginPageController =
                    SignupUseCaseFactory.createViewLoginPageController(loginViewModel, viewManagerModel);
            ViewProfileController viewProfileController =
                    createProfileController(viewManagerModel, viewProfileViewModel);
            GetSearchPageController getSearchPageController = createGetSearchPageController(viewManagerModel, searchProductViewModel);
            ViewSignupPageController viewSignupPageController = creatViewSignupPageController(viewManagerModel, signupViewModel);
            LogOutController logOutController = createLogOutController(viewManagerModel, mainPageViewModel);


            return new SignupView(signupController, signupViewModel, emailVerificationController,
                    mainPageController, shoppingCartController, searchProductByNameController,
                    searchProductByTagController, viewLoginPageController, getSearchPageController, viewSignupPageController,
                    logOutController, viewProfileController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Creates an instance of {@link SearchProductByNameController}.
     *
     * @param viewManagerModel       the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link SearchProductByNameController}
     * @throws SQLException if a database access error occurs
     */
    private static SearchProductByNameController createSearchProductByNameController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {


        SearchProductByNameOutputBoundary presenter = new SearchProductByNamePresenter(viewManagerModel, searchProductViewModel);

        DatabaseProductReadByNameDataAccessObjectFactoryInterface databaseProductReadByNameDataAccessObjectFactory =
                new DatabaseProductReadByNameDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByNameDataAccessInterface productReadByNameDataAccessObject = databaseProductReadByNameDataAccessObjectFactory.create(productFactory, scheduleFactory);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface =
                new DatabaseProductReadAllDataAccessObjectFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        SearchProductByNameInputBoundary interactor = new SearchProductByNameInteractor(productReadAllDataAccessObeject, productReadByNameDataAccessObject, presenter);
        return new SearchProductByNameController(interactor);
    }

    /**
     * Creates an instance of {@link SignupController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @param loginViewModel   the login view model
     * @return an instance of {@link SignupController}
     * @throws IOException  if an I/O error occurs
     * @throws SQLException if a database access error occurs
     */
    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory
                = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject = databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory
                = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface =
                databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());
        DatabaseShoppingCartCreateDataAccessObjectFactoryInterface databaseShoppingCartCreateDataAccessObjectFactory =
                new DatabaseShoppingCartCreateDataAccessObjectFactory();
        ShoppingCartCreateDataAccessInterface shoppingCartCreateDataAccessObject =
                databaseShoppingCartCreateDataAccessObjectFactory.create();

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory, shoppingCartCreateDataAccessObject);

        return new SignupController(userSignupInteractor);
    }

    /**
     * Creates an instance of {@link ViewSignupPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @return an instance of {@link ViewSignupPageController}
     */
    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }

    /**
     * Creates an instance of {@link EmailVerificationController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @return an instance of {@link EmailVerificationController}
     */
    private static EmailVerificationController createEmailVerifyUseCase(ViewManagerModel viewManagerModel,
                                                                        SignupViewModel signupViewModel) {
        EmailVerificationOutputBoundary emailVerificationOutputBoundary = new
                EmailVerificationPresenter(viewManagerModel, signupViewModel);
        EmailVerificationInputBoundary emailVerificationInteractor = new
                EmailVerificationInteractor(emailVerificationOutputBoundary);
        return new EmailVerificationController(emailVerificationInteractor);
    }

    /**
     * Creates an instance of {@link ShoppingCartController}.
     *
     * @param viewManagerModel     the view manager model
     * @param shoppingCartViewModel the shopping cart view model
     * @return an instance of {@link ShoppingCartController}
     * @throws SQLException if a database access error occurs
     */

    private static ShoppingCartController createShoppingCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShowShoppingCartOutputBoundary presenter = new ShoppingCartPresenter(viewManagerModel,
                shoppingCartViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory, scheduleFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    /**
     * Creates an instance of {@link MainPageController}.
     *
     * @param mainPageViewModel the main page view model
     * @param viewManagerModel  the view manager model
     * @return an instance of {@link MainPageController}
     * @throws SQLException if a database access error occurs
     */
    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        ShowMainPageInputBoundary showMainPageInteractor =
                new ShowMainPageInteractor(showMainPagePresenter, productReadAllDataAccessObeject);
        return new MainPageController(showMainPageInteractor);
    }

//    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel,
//                                                                         ViewManagerModel viewManagerModel){
//
//        ViewLoginPageOutputBoundary viewLoginPagePresenter =
//                new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
//        ViewLoginPageInputBoundary viewLoginPageInteractor =
//                new ViewLoginPageInteractor(viewLoginPagePresenter);
//        return new ViewLoginPageController(viewLoginPageInteractor);
//    }


    /**
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param loginViewModel   the login view model
     * @param viewManagerModel the view manager model
     * @return an instance of {@link ViewLoginPageController}
     */
    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel, ViewManagerModel viewManagerModel){

        ViewLoginPageOutputBoundary viewLoginPagePresenter = new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    /**
     * Creates an instance of {@link LogOutController}.
     *
     * @param viewManagerModel  the view manager model
     * @param mainPageViewModel the main page view model
     * @return an instance of {@link LogOutController}
     * @throws SQLException if a database access error occurs
     */
    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    /**
     * Creates an instance of {@link ViewProfileController}.
     *
     * @param viewManagerModel   the view manager model
     * @param profileViewModel the profile view model
     * @return an instance of {@link ViewProfileController}
     * @throws IOException if an I/O error occurs
     */
    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    /**
     * Creates an instance of {@link GetSearchPageController}.
     *
     * @param viewManagerModel       the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link GetSearchPageController}
     * @throws SQLException if a database access error occurs
     */
    private static GetSearchPageController createGetSearchPageController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        GetSearchViewOutputBoundary getSearchViewPresenter =
                new GetSearchPagePresenter(searchProductViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        GetSearchViewInputBoundary getSearchViewInteractor =
                new GetSearchViewInteractor(getSearchViewPresenter, productReadAllDataAccessObeject);
        return new GetSearchPageController(getSearchViewInteractor);
    }

    /**
     * Creates an instance of {@link SearchProductByTagController}.
     *
     * @param viewManagerModel       the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link SearchProductByTagController}
     * @throws SQLException if a database access error occurs
     */
    private static SearchProductByTagController createSearchProductByTagController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        SearchProductByTagOutputBoundary presenter = new SearchProductByTagPresenter(searchProductViewModel, viewManagerModel);

        DatabaseProductReadByTagDataAccessObjectFactoryInterface databaseProductReadByTagDataAccessObjectFactory =
                new DatabaseProductReadByTagDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByTagDataAccessInterface productReadByTageDataAccessObject = databaseProductReadByTagDataAccessObjectFactory.create(productFactory, scheduleFactory);
        SearchProductByTagInputBoundary interactor = new SearchProductByTagInteractor(productReadByTageDataAccessObject, presenter);
        return new SearchProductByTagController(interactor);
    }
}

