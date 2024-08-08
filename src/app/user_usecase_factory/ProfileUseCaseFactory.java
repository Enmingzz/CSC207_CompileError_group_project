package app.user_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DataBaseProductReadByIdDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByUserDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductPresenter;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.modify_profile.ViewModifyProfileController;
import interface_adapter.profile.modify_profile.ViewModifyProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.search_product.view_search_page.GetSearchPagePresenter;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import interface_adapter.signup.view_signup_page.ViewSignupPagePresenter;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileInputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileInteractor;
import use_case.profile.modify_profile.ViewModifyProfileOutputBoundary;
import use_case.search_product.*;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInteractor;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.*;
import view.profile.ProfileView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Class responsible for creating a new instance of ProfileView
 */

public class ProfileUseCaseFactory {

    /**
     * Creates and initializes a {@link ProfileView} instance with the necessary controllers and view models.
     *
     * @param viewManagerModel       the view manager model
     * @param signupViewModel        the signup view model
     * @param loginViewModel         the login view model
     * @param mainPageViewModel      the main page view model
     * @param shoppingCartViewModel  the shopping cart view model
     * @param manageProductViewModel the manage product view model
     * @param searchProductViewModel the search product view model
     * @param viewProfileViewModel   the view profile view model
     * @param modifyProfileViewModel the modify profile view model
     * @return a {@link ProfileView} instance initialized with the specified controllers and view models
     * @throws IOException  if an input/output error occurs
     * @throws SQLException if a database access error occurs
     */

    public static ProfileView create(ViewManagerModel viewManagerModel,
                                     SignupViewModel signupViewModel,
                                     LoginViewModel loginViewModel,
                                     MainPageViewModel mainPageViewModel,
                                     ShoppingCartViewModel shoppingCartViewModel,
                                     ManageProductViewModel manageProductViewModel,
                                     SearchProductViewModel searchProductViewModel,
                                     ViewProfileViewModel viewProfileViewModel,
                                     ModifyProfileViewModel modifyProfileViewModel) throws IOException, SQLException {

        ManageProductController manageProductController =
                ProfileUseCaseFactory.createManageProductController(viewManagerModel, manageProductViewModel);
        ViewModifyProfileController viewModifyProfileController =
                ProfileUseCaseFactory.createViewModifyProfileController(modifyProfileViewModel, viewManagerModel);

        //Top Bar stuff
        ViewProfileController viewProfileController =
                ProfileUseCaseFactory.createProfileController(viewManagerModel, viewProfileViewModel);
        MainPageController mainPageController =
                ProfileUseCaseFactory.createMainPageController(mainPageViewModel, viewManagerModel);
        ShoppingCartController shoppingCartController =
                ProfileUseCaseFactory.createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        GetSearchPageController getSearchPageController =
                ProfileUseCaseFactory.createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController =
                ProfileUseCaseFactory.creatViewSignupPageController(viewManagerModel, signupViewModel);
        ViewLoginPageController viewLoginPageController =
                ProfileUseCaseFactory.createViewLoginPageController(loginViewModel, viewManagerModel);
        LogOutController logOutController =
                ProfileUseCaseFactory.createLogOutController(viewManagerModel, mainPageViewModel);

        return new ProfileView(mainPageController,
                manageProductController,
                viewModifyProfileController,
                viewProfileViewModel,
                getSearchPageController,
                viewSignupPageController,
                viewLoginPageController,
                shoppingCartController,
                logOutController,
                viewProfileController
                );
    }

//    /**
//     * Creates an instance of {@link SignupController}.
//     *
//     * @param viewManagerModel the view manager model
//     * @param signupViewModel  the signup view model
//     * @param loginViewModel   the login view model
//     * @return an instance of {@link SignupController}
//     * @throws IOException  if an I/O error occurs
//     * @throws SQLException if a database access error occurs
//     */

//    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {
//
//        //TODO: CHECK WHETHER THIS CAN BE DELETED OR NOT
          //THIS PROBS CAN BE DELETED

//        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory = new DatabaseUserCreateDataAccessObjectFactory();
//        UserCreateDataAccessInterface userCreateDataAccessObject = databaseUserCreateDataAccessObjectFactory.create();
//        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
//        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
//        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());
//
//        UserFactory userFactory = new CommonUserFactory();
//
//        SignupInputBoundary userSignupInteractor = new SignupInteractor(
//                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory);
//
//        return new SignupController(userSignupInteractor);
//    }

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

        DataBaseProductReadByIdDataAccessObjectFactoryInterface dataBaseProductReadByIdDataAccessObjectFactory =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                dataBaseProductReadByIdDataAccessObjectFactory.create(productFactory, scheduleFactory);

        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess, productReadByIdDataAccessObject, shoppingCartFactory);
        return new ShoppingCartController(showShoppingCartInteractor);
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
     * @param viewManagerModel  the view manager model
     * @param profileViewModel  the view profile view model
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
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param loginViewModel   the login view model
     * @param viewManagerModel the view manager model
     * @return an instance of {@link ViewLoginPageController}
     */

    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel,
                                                                         ViewManagerModel viewManagerModel){

        ViewLoginPageOutputBoundary viewLoginPagePresenter =
                new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    /**
     * Creates a {@link ManageProductController} instance.
     *
     * @param viewManagerModel       the view manager model
     * @param manageProductViewModel the manage product view model
     * @return a {@link ManageProductController} instance
     * @throws SQLException if a database access error occurs
     */

    private static ManageProductController createManageProductController(
            ViewManagerModel viewManagerModel, ManageProductViewModel manageProductViewModel) throws SQLException {
        ManageProductOutputBoundary manageProductPresenter =
                new ManageProductPresenter(viewManagerModel, manageProductViewModel);
        DatabaseProductReadByUserDataAccessObjectFactoryInterface databaseProductReadByUserDataAccessObjectFactoryInterface
                = new DatabaseProductReadByUserDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByUserDataAccessInterface productReadByUserDataAccessObject =
                databaseProductReadByUserDataAccessObjectFactoryInterface.create(productFactory,
                        scheduleFactory);
        ManageProductInputBoundary manageProductInteractor =
                new ManageProductInteractor(manageProductPresenter, productReadByUserDataAccessObject);
        return new ManageProductController(manageProductInteractor);
    }

    /**
     * Creates a {@link ViewModifyProfileController} instance.
     *
     * @param modifyProfileViewModel the modify profile view model
     * @param viewManagerModel       the view manager model
     * @return a {@link ViewModifyProfileController} instance
     */

    private static ViewModifyProfileController createViewModifyProfileController(
            ModifyProfileViewModel modifyProfileViewModel,
            ViewManagerModel viewManagerModel) {
        ViewModifyProfileOutputBoundary viewModifyProfilePresenter =
                new ViewModifyProfilePresenter(modifyProfileViewModel, viewManagerModel, new CommonUserFactory());
        ViewModifyProfileInputBoundary viewModifyProfileInteractor =
                new ViewModifyProfileInteractor(viewModifyProfilePresenter);
        return new ViewModifyProfileController(viewModifyProfileInteractor);
    }



}
