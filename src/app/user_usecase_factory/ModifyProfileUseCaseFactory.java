package app.user_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserUpdateNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByUserDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserUpdateNameDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserUpdatePasswordDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ViewModifyProductController;
import interface_adapter.modify_product.ViewModifyProductPresenter;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductPresenter;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ModifyProfilePresenter;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.signup.ViewSignupPagePresenter;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.modify_product.ViewModifyProductInputBoundary;
import use_case.modify_product.ViewModifyProductInteractor;
import use_case.modify_product.ViewModifyProductOutputBoundary;
import use_case.search_product.*;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInteractor;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.modify_profile.ModifyProfileInputBoundary;
import use_case.profile.modify_profile.ModifyProfileInteractor;
import use_case.profile.modify_profile.ModifyProfileOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.ViewSignupPageInputBoundary;
import use_case.signup.ViewSignupPageInteractor;
import use_case.signup.ViewSignupPageOutputBoundary;
import view.profile.ModifyProfileView;

import java.sql.SQLException;

/**
 * Factory class to create instances related to the modify profile use case.
 */
public class ModifyProfileUseCaseFactory {

    /**
     * Creates an instance of {@link ModifyProfileView} with the necessary controllers and view models.
     *
     * @param viewManagerModel       the view manager model
     * @param mainPageViewModel      the main page view model
     * @param shoppingCartViewModel  the shopping cart view model
     * @param searchProductViewModel the search product view model
     * @param viewProfileViewModel   the view profile view model
     * @param signUpViewModel        the signup view model
     * @param loginViewModel         the login view model
     * @param modifyProfileViewModel the modify profile view model
     * @return an instance of {@link ModifyProfileView}
     * @throws SQLException if a database access error occurs
     */
    public static ModifyProfileView create(ViewManagerModel viewManagerModel,
                                           MainPageViewModel mainPageViewModel,
                                           ShoppingCartViewModel shoppingCartViewModel,
                                           SearchProductViewModel searchProductViewModel,
                                           ViewProfileViewModel viewProfileViewModel,
                                           SignupViewModel signUpViewModel,
                                           LoginViewModel loginViewModel,
                                           ModifyProfileViewModel modifyProfileViewModel) throws SQLException {

            UserFactory userFactory = new CommonUserFactory();
            MainPageController mainPageController =
                    ModifyProfileUseCaseFactory.createMainPageController(mainPageViewModel,
                            viewManagerModel);
            ModifyProfileController modifyProfileController =
                    ModifyProfileUseCaseFactory.createModifyProfileController(modifyProfileViewModel, viewProfileViewModel,
                            viewManagerModel);
            ShoppingCartController shoppingCartController =
                    ModifyProfileUseCaseFactory.createShoppingCartController(viewManagerModel,
                            shoppingCartViewModel);
            SearchProductByNameController searchProductByNameController =
                    ModifyProfileUseCaseFactory.createSearchProductByNameController(viewManagerModel,
                            searchProductViewModel);
            ViewProfileController viewProfileController = createProfileController(viewManagerModel, viewProfileViewModel);
            GetSearchPageController getSearchPageController = createGetSearchPageController(viewManagerModel, searchProductViewModel);
            ViewSignupPageController viewSignupPageController = createViewSignupPageController(viewManagerModel, signUpViewModel);
            ViewLoginPageController viewLoginPageController = createViewLoginPageController(viewManagerModel, loginViewModel);
            LogOutController logOutController = createLogOutController(viewManagerModel, mainPageViewModel);


            return new ModifyProfileView(modifyProfileViewModel, userFactory,
                    modifyProfileController,
                     mainPageController,
                     shoppingCartController,
                     searchProductByNameController,
                     viewProfileController,
                     getSearchPageController,
                     viewSignupPageController,
                     viewLoginPageController,
                     logOutController);

    }

    /**
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param loginViewModel   the login view model
     * @return an instance of {@link ViewLoginPageController}
     */
    private static ViewLoginPageController createViewLoginPageController(ViewManagerModel viewManagerModel,
                                                                         LoginViewModel loginViewModel){
        ViewLoginPageOutputBoundary viewLoginPageOutputpresenter =
                new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPageOutputpresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    /**
     * Creates an instance of {@link ViewSignupPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @return an instance of {@link ViewSignupPageController}
     */
    private static ViewSignupPageController createViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }

    /**
     * Creates an instance of {@link SearchProductByNameController}.
     *
     * @param viewManagerModel     the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link SearchProductByNameController}
     * @throws SQLException if a database access error occurs
     */
    private static SearchProductByNameController createSearchProductByNameController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {

        DatabaseProductReadByNameDataAccessObjectFactoryInterface daoFactory = new DatabaseProductReadByNameDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        ProductReadByNameDataAccessInterface productSearchByNameDAO = daoFactory.create(productFactory, scheduleFactory);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface =
                new DatabaseProductReadAllDataAccessObjectFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        SearchProductByNameOutputBoundary presenter = new SearchProductByNamePresenter(viewManagerModel, searchProductViewModel);
        SearchProductByNameInputBoundary interactor = new SearchProductByNameInteractor(productReadAllDataAccessObeject, productSearchByNameDAO, presenter);
        return new SearchProductByNameController(interactor);
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
     */
    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    /**
     * Creates an instance of {@link GetSearchPageController}.
     *
     * @param viewManagerModel     the view manager model
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
     * Creates an instance of {@link ModifyProfileController}.
     *
     * @param modifyProfileViewModel the modify profile view model
     * @param viewProfileViewModel   the view profile view model
     * @param viewManagerModel       the view manager model
     * @return an instance of {@link ModifyProfileController}
     * @throws SQLException if a database access error occurs
     */
    private static ModifyProfileController createModifyProfileController(ModifyProfileViewModel modifyProfileViewModel,
                                                                         ViewProfileViewModel viewProfileViewModel,
                                                                         ViewManagerModel viewManagerModel) throws SQLException {
        DatabaseUserUpdateNameDataAccessObjectFactoryInterface databaseUserUpdateNameDataAccessObjectFactoryInterface
                = new DatabaseUserUpdateNameDataAccessObjectFactory();
        UserUpdateNameDataAccessInterface userUpdateNameDataAccessObject =
                databaseUserUpdateNameDataAccessObjectFactoryInterface.create();
        DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface databaseUserUpdatePasswordDataAccessObjectFactoryInterface = new
                DatabaseUserUpdatePasswordDataAccessObjectFactory();
        UserFactory userFactory = new CommonUserFactory();
        DatabaseUserReadDataAccessObjectFactoryInterface userReadDataAccessObjectFactoryInterface = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessObject =
                userReadDataAccessObjectFactoryInterface.create(userFactory);
        UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessObject =
                databaseUserUpdatePasswordDataAccessObjectFactoryInterface.create();
        ModifyProfileOutputBoundary modifyProfilePresenter = new ModifyProfilePresenter(modifyProfileViewModel, viewProfileViewModel,
                viewManagerModel);
        ModifyProfileInputBoundary modifyProfileInteractor =
                new ModifyProfileInteractor(userUpdateNameDataAccessObject,
                                        userUpdatePasswordDataAccessObject, userReadDataAccessObject,
                                        modifyProfilePresenter);

        return new ModifyProfileController(modifyProfileInteractor);
    }

    /**
     * Creates an instance of {@link ManageProductController}.
     *
     * @param viewManagerModel      the view manager model
     * @param manageProductViewModel the manage product view model
     * @return an instance of {@link ManageProductController}
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
     * Creates an instance of {@link ViewModifyProductController}.
     *
     * @param viewModifyProductViewModel the modify product view model
     * @param viewManagerModel           the view manager model
     * @return an instance of {@link ViewModifyProductController}
     */
    private static ViewModifyProductController createModifyProductController(ViewModifyProductViewModel viewModifyProductViewModel, ViewManagerModel viewManagerModel){
        ViewModifyProductOutputBoundary presenter = new ViewModifyProductPresenter(viewModifyProductViewModel, viewManagerModel);
        ViewModifyProductInputBoundary modifyProductInteractor = new ViewModifyProductInteractor(presenter);
        return new ViewModifyProductController(modifyProductInteractor);
    }

}
